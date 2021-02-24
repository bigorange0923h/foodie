package com.foodie.service.impl;

import com.foodie.enums.OrderStatusEnum;
import com.foodie.enums.YesOrNo;
import com.foodie.mapper.OrderItemsMapper;
import com.foodie.mapper.OrderStatusMapper;
import com.foodie.mapper.OrdersMapper;
import com.foodie.pojo.*;
import com.foodie.pojo.bo.SubmitOrderBO;
import com.foodie.service.ItemsService;
import com.foodie.service.ItemsSpecService;
import com.foodie.service.OrdersService;
import com.foodie.service.UserAddressService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 订单表;(Orders)表服务实现类
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private Sid sid;

    @Autowired
    private OrdersMapper mapper;

    @Autowired
    private UserAddressService addressService;

    @Autowired
    private ItemsSpecService itemsSpecService;

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private OrderItemsMapper orderItemsMapper;

    @Autowired
    private OrderStatusMapper orderStatusMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public String create(SubmitOrderBO orderBO) {

        //获取对应地址信息
        UserAddress address = addressService.queryUserAddress(orderBO.getUserId(), orderBO.getAddressId());

        Integer postAmount = 0;

        //1.创建订单数据
        Orders newOrder = new Orders();
        newOrder.setId(sid.nextShort());
        newOrder.setUserId(orderBO.getUserId());

        newOrder.setReceiverName(address.getReceiver());
        newOrder.setReceiverMobile(address.getMobile());
        newOrder.setReceiverAddress(address.getProvince()+" "
                                    +address.getCity()+" "
                                    +address.getDistrict()+" "
                                    +address.getDetail());

        newOrder.setPostAmount(postAmount);
        newOrder.setPayMethod(orderBO.getPayMethod());
        newOrder.setLeftMsg(orderBO.getLeftMsg());
        newOrder.setIsComment(YesOrNo.NO.type);
        newOrder.setIsDelete(YesOrNo.NO.type);
        newOrder.setCreatedTime(new Date());
        newOrder.setUpdatedTime(new Date());

        //2.循环itemSpecIds 保存商品订单信息表
        String[] itemSpectIdArr = orderBO.getItemSpecIds().split(",");
        Integer totalAmount = 0; // 商品原价
        Integer realPayAmount = 0; //实付金额
        for (String itemSpecId : itemSpectIdArr) {
                int buyCount = 1;
            //2.1 根据规格ID,查询具体规格信息
                ItemsSpec itemsSpec = itemsSpecService.queryItemSpecById(itemSpecId);
            //todo 整合redis 后 商品数量重新从redis 中获取
                totalAmount += itemsSpec.getPriceNormal() * buyCount;
                realPayAmount += itemsSpec.getPriceDiscount()*buyCount;
            //2.2 根据商品ID 获取商品信息及图片
                Items items = itemsService.queryItemsById(itemsSpec.getItemId());
                String imgUrl = itemsService.queryItemMainImgById(itemsSpec.getItemId());
            //2.3 循环保存子订单信息
                OrderItems orderItems = new OrderItems();
                orderItems.setId(sid.nextShort());
                orderItems.setOrderId(newOrder.getId());
                orderItems.setItemId(itemsSpec.getItemId());
                orderItems.setItemName(items.getItemName());
                orderItems.setItemImg(imgUrl);
                orderItems.setBuyCounts(buyCount);
                orderItems.setItemSpecId(itemSpecId);
                orderItems.setItemSpecName(itemsSpec.getName());
                orderItems.setPrice(itemsSpec.getPriceDiscount());
                orderItemsMapper.insert(orderItems);
            //2.4 扣除库存
                itemsSpecService.decreaseItemSpecStock(itemSpecId,buyCount);
        }
        newOrder.setTotalAmount(totalAmount);
        newOrder.setRealPayAmount(realPayAmount);
        mapper.insert(newOrder);

        // 3 保存订单状态信息
        OrderStatus waitOrderStatus = new OrderStatus();
        waitOrderStatus.setOrderId(newOrder.getId());
        waitOrderStatus.setOrderStatus(OrderStatusEnum.WAIT_PAY.type);
        waitOrderStatus.setCreatedTime(new Date());
        orderStatusMapper.insert(waitOrderStatus);
        return newOrder.getId();
    }
}