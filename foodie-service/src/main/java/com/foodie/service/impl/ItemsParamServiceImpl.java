package com.foodie.service.impl;

import com.foodie.mapper.ItemsParamDao;
import com.foodie.pojo.ItemsParam;
import com.foodie.service.ItemsParamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品参数(ItemsParam)表服务实现类
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
@Service("itemsParamService")
public class ItemsParamServiceImpl implements ItemsParamService {
    @Resource
    private ItemsParamDao itemsParamDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItemsParam queryById(String id) {
        return this.itemsParamDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItemsParam> queryAllByLimit(int offset, int limit) {
        return this.itemsParamDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itemsParam 实例对象
     * @return 实例对象
     */
    @Override
    public ItemsParam insert(ItemsParam itemsParam) {
        this.itemsParamDao.insert(itemsParam);
        return itemsParam;
    }

    /**
     * 修改数据
     *
     * @param itemsParam 实例对象
     * @return 实例对象
     */
    @Override
    public ItemsParam update(ItemsParam itemsParam) {
        this.itemsParamDao.update(itemsParam);
        return this.queryById(itemsParam.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.itemsParamDao.deleteById(id) > 0;
    }
}