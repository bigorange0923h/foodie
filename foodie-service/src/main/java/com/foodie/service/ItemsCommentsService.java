package com.foodie.service;

import com.foodie.pojo.ItemsComments;
import java.util.List;

/**
 * 商品评价表(ItemsComments)表服务接口
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
public interface ItemsCommentsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItemsComments queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItemsComments> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param itemsComments 实例对象
     * @return 实例对象
     */
    ItemsComments insert(ItemsComments itemsComments);

    /**
     * 修改数据
     *
     * @param itemsComments 实例对象
     * @return 实例对象
     */
    ItemsComments update(ItemsComments itemsComments);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}