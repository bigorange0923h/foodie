package com.foodie.service.impl;

import com.foodie.mapper.ItemsImgDao;
import com.foodie.pojo.ItemsImg;
import com.foodie.service.ItemsImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品图片(ItemsImg)表服务实现类
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
@Service("itemsImgService")
public class ItemsImgServiceImpl implements ItemsImgService {
    @Resource
    private ItemsImgDao itemsImgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItemsImg queryById(String id) {
        return this.itemsImgDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItemsImg> queryAllByLimit(int offset, int limit) {
        return this.itemsImgDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itemsImg 实例对象
     * @return 实例对象
     */
    @Override
    public ItemsImg insert(ItemsImg itemsImg) {
        this.itemsImgDao.insert(itemsImg);
        return itemsImg;
    }

    /**
     * 修改数据
     *
     * @param itemsImg 实例对象
     * @return 实例对象
     */
    @Override
    public ItemsImg update(ItemsImg itemsImg) {
        this.itemsImgDao.update(itemsImg);
        return this.queryById(itemsImg.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.itemsImgDao.deleteById(id) > 0;
    }
}