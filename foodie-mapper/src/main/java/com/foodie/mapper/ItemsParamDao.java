package com.foodie.mapper;

import com.foodie.pojo.ItemsParam;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 商品参数(ItemsParam)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
public interface ItemsParamDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItemsParam queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItemsParam> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param itemsParam 实例对象
     * @return 对象列表
     */
    List<ItemsParam> queryAll(ItemsParam itemsParam);

    /**
     * 新增数据
     *
     * @param itemsParam 实例对象
     * @return 影响行数
     */
    int insert(ItemsParam itemsParam);

    /**
     * 修改数据
     *
     * @param itemsParam 实例对象
     * @return 影响行数
     */
    int update(ItemsParam itemsParam);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}