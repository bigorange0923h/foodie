package com.foodie.mapper;

import com.foodie.pojo.Items;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表(Items)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
public interface ItemsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Items queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Items> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param items 实例对象
     * @return 对象列表
     */
    List<Items> queryAll(Items items);

    /**
     * 新增数据
     *
     * @param items 实例对象
     * @return 影响行数
     */
    int insert(Items items);

    /**
     * 修改数据
     *
     * @param items 实例对象
     * @return 影响行数
     */
    int update(Items items);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}