package com.foodie.mapper;

import com.foodie.pojo.ItemsSpec;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计(ItemsSpec)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
public interface ItemsSpecDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItemsSpec queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItemsSpec> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param itemsSpec 实例对象
     * @return 对象列表
     */
    List<ItemsSpec> queryAll(ItemsSpec itemsSpec);

    /**
     * 新增数据
     *
     * @param itemsSpec 实例对象
     * @return 影响行数
     */
    int insert(ItemsSpec itemsSpec);

    /**
     * 修改数据
     *
     * @param itemsSpec 实例对象
     * @return 影响行数
     */
    int update(ItemsSpec itemsSpec);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}