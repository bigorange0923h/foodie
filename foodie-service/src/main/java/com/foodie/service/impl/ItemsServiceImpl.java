package com.foodie.service.impl;

import com.foodie.enums.CommentLevel;
import com.foodie.enums.YesOrNo;
import com.foodie.mapper.*;
import com.foodie.pojo.*;
import com.foodie.pojo.vo.CommentLevelCountsVO;
import com.foodie.pojo.vo.ItemCommentVO;
import com.foodie.pojo.vo.ShopcartVO;
import com.foodie.service.ItemsService;
import com.foodie.service.com.foodie.my.service.MyService;
import com.foodie.utils.DesensitizationUtil;
import com.foodie.utils.PagedGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表(Items)表服务实现类
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
@Service
public class ItemsServiceImpl extends MyService implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private ItemsImgMapper itemsImgMapper;
    @Autowired
    private ItemsSpecMapper itemsSpecMapper;
    @Autowired
    private ItemsParamMapper itemsParamMapper;
    @Autowired
    private ItemsCommentsMapper itemsCommentsMapper;

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Items queryItemsById(String id) {
        return itemsMapper.selectByPrimaryKey(id);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsImg> queryItemsImgList(String itemId) {
        Example example = new Example(ItemsImg.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsImgMapper.selectByExample(example);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsSpec> queryItemsSpecList(String itemId) {
        Example example = new Example(ItemsSpec.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsSpecMapper.selectByExample(example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ItemsParam queryItemsParam(String itemId) {
        Example example = new Example(ItemsParam.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsParamMapper.selectOneByExample(example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public CommentLevelCountsVO queryCommentCounts(String itemId) {
        Integer goodCounts = getCommentCounts(itemId, CommentLevel.GOOD.type);
        Integer normalCounts = getCommentCounts(itemId, CommentLevel.NORMAL.type);
        Integer badCounts = getCommentCounts(itemId, CommentLevel.BAD.type);
        Integer totalCounts = goodCounts+normalCounts+badCounts;
        CommentLevelCountsVO commentLevelCountsVO = new CommentLevelCountsVO();
            commentLevelCountsVO.setBadCounts(badCounts);
            commentLevelCountsVO.setGoodCounts(goodCounts);
            commentLevelCountsVO.setNormalCounts(normalCounts);
            commentLevelCountsVO.setTotalCounts(totalCounts);
        return commentLevelCountsVO;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer  getCommentCounts(String itemId,Integer level){
        ItemsComments condition = new ItemsComments();
        condition.setItemId(itemId);
        condition.setCommentLevel(level);
        return itemsCommentsMapper.selectCount(condition);
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult queryPagedComments(String itemId, Integer level,Integer page,Integer pageSize) {
        Map<String,Object> map= new HashMap();
        map.put("itemId",itemId);
        map.put("level",level);
        PageHelper.startPage(page,pageSize);
        List<ItemCommentVO> itemCommentVOS = itemsMapperCustom.queryItemComments(map);
        for (ItemCommentVO itemCommentVO : itemCommentVOS) {
            itemCommentVO.setNickname(DesensitizationUtil.commonDisplay(
                    itemCommentVO.getNickname()));
        }
        return setterPagedGrid(itemCommentVOS,page);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult searchItems(String keywords, String sort, Integer page, Integer pageSize) {
        Map<String,Object> map = new HashMap<>();
        map.put("keywords",keywords);
        map.put("sort",sort);
        PageHelper.startPage(page,pageSize);
        return setterPagedGrid(itemsMapperCustom.searchItems(map),page);

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult searchItems(Integer catId, String sort, Integer page, Integer pageSize) {
        Map<String,Object> map = new HashMap<>();
        map.put("catId",catId);
        map.put("sort",sort);
        PageHelper.startPage(page,pageSize);
        return setterPagedGrid(itemsMapperCustom.searchItemsByThirdCat(map),page);

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ShopcartVO> queryItemsBySpecIds(String specIds) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,specIds.split(","));
        return itemsMapperCustom.queryItemsBySpecIds(list);
    }

    @Override
    public String queryItemMainImgById(String itemId) {
        ItemsImg itemsImg = new ItemsImg();
        itemsImg.setId(itemId);
        itemsImg.setIsMain(YesOrNo.YES.type);
        ItemsImg img = itemsImgMapper.selectOne(itemsImg);
        return img != null ? img.getUrl() : "";
    }
}