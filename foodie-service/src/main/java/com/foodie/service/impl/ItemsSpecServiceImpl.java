package com.foodie.service.impl;

import com.foodie.mapper.ItemsSpecDao;
import com.foodie.pojo.ItemsSpec;
import com.foodie.service.ItemsSpecService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计(ItemsSpec)表服务实现类
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
@Service("itemsSpecService")
public class ItemsSpecServiceImpl implements ItemsSpecService {
    @Resource
    private ItemsSpecDao itemsSpecDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItemsSpec queryById(String id) {
        return this.itemsSpecDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItemsSpec> queryAllByLimit(int offset, int limit) {
        return this.itemsSpecDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itemsSpec 实例对象
     * @return 实例对象
     */
    @Override
    public ItemsSpec insert(ItemsSpec itemsSpec) {
        this.itemsSpecDao.insert(itemsSpec);
        return itemsSpec;
    }

    /**
     * 修改数据
     *
     * @param itemsSpec 实例对象
     * @return 实例对象
     */
    @Override
    public ItemsSpec update(ItemsSpec itemsSpec) {
        this.itemsSpecDao.update(itemsSpec);
        return this.queryById(itemsSpec.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.itemsSpecDao.deleteById(id) > 0;
    }
}