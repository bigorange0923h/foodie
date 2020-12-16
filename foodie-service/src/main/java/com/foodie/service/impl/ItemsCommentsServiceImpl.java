package com.foodie.service.impl;

import com.foodie.mapper.ItemsCommentsDao;
import com.foodie.pojo.ItemsComments;
import com.foodie.service.ItemsCommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品评价表(ItemsComments)表服务实现类
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
@Service("itemsCommentsService")
public class ItemsCommentsServiceImpl implements ItemsCommentsService {
    @Resource
    private ItemsCommentsDao itemsCommentsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItemsComments queryById(String id) {
        return this.itemsCommentsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItemsComments> queryAllByLimit(int offset, int limit) {
        return this.itemsCommentsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itemsComments 实例对象
     * @return 实例对象
     */
    @Override
    public ItemsComments insert(ItemsComments itemsComments) {
        this.itemsCommentsDao.insert(itemsComments);
        return itemsComments;
    }

    /**
     * 修改数据
     *
     * @param itemsComments 实例对象
     * @return 实例对象
     */
    @Override
    public ItemsComments update(ItemsComments itemsComments) {
        this.itemsCommentsDao.update(itemsComments);
        return this.queryById(itemsComments.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.itemsCommentsDao.deleteById(id) > 0;
    }
}