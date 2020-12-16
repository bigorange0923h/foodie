package com.foodie.service;

import com.foodie.pojo.Carousel;
import java.util.List;

/**
 * 轮播图(Carousel)表服务接口
 *
 * @author makejava
 * @since 2020-12-08 14:43:57
 */
public interface CarouselService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Carousel queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Carousel> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param carousel 实例对象
     * @return 实例对象
     */
    Carousel insert(Carousel carousel);

    /**
     * 修改数据
     *
     * @param carousel 实例对象
     * @return 实例对象
     */
    Carousel update(Carousel carousel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}