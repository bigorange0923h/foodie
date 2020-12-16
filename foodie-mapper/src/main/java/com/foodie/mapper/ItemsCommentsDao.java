package com.foodie.mapper;

import com.foodie.pojo.ItemsComments;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 商品评价表(ItemsComments)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
public interface ItemsCommentsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItemsComments queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItemsComments> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param itemsComments 实例对象
     * @return 对象列表
     */
    List<ItemsComments> queryAll(ItemsComments itemsComments);

    /**
     * 新增数据
     *
     * @param itemsComments 实例对象
     * @return 影响行数
     */
    int insert(ItemsComments itemsComments);

    /**
     * 修改数据
     *
     * @param itemsComments 实例对象
     * @return 影响行数
     */
    int update(ItemsComments itemsComments);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}