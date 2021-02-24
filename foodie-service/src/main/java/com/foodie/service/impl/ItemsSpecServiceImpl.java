package com.foodie.service.impl;

import com.foodie.mapper.ItemsSpecMapper;
import com.foodie.pojo.ItemsSpec;
import com.foodie.service.ItemsSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计(ItemsSpec)表服务实现类
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
@Service("itemsSpecService")
public class ItemsSpecServiceImpl implements ItemsSpecService {

    @Autowired
    ItemsSpecMapper mapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ItemsSpec queryItemSpecById(String specId) {
        return mapper.selectByPrimaryKey(specId);
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void decreaseItemSpecStock(String specId, int buyCounts) {
        //synchronized 不推荐使用 ,进群下无用 而且性能低下
        // 锁数据库:不推荐,导致数据库性能低下
        // 分布式锁: zookeeper redis

        //lockUtil.getLock(); -- 加锁

        //1 查询库存
        int stock = 10;
        //2 判断 库存,是否能够减少到0以下
        if(stock - buyCounts <0){
            //提示库存不够
        }
        int result = mapper.decreaseItemSpecStock(specId,buyCounts);
        if (result != 1){
            throw  new RuntimeException("订单创建失败,原因:库存不足!");
        }
        //lockUtil.unLock(); -- 解锁
    }
}