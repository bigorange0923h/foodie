package com.foodie.service.impl;

import com.foodie.mapper.CarouselDao;
import com.foodie.pojo.Carousel;
import com.foodie.service.CarouselService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 轮播图(Carousel)表服务实现类
 *
 * @author makejava
 * @since 2020-12-08 14:43:58
 */
@Service("carouselService")
public class CarouselServiceImpl implements CarouselService {
    @Resource
    private CarouselDao carouselDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Carousel queryById(String id) {
        return this.carouselDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Carousel> queryAllByLimit(int offset, int limit) {
        return this.carouselDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param carousel 实例对象
     * @return 实例对象
     */
    @Override
    public Carousel insert(Carousel carousel) {
        this.carouselDao.insert(carousel);
        return carousel;
    }

    /**
     * 修改数据
     *
     * @param carousel 实例对象
     * @return 实例对象
     */
    @Override
    public Carousel update(Carousel carousel) {
        this.carouselDao.update(carousel);
        return this.queryById(carousel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.carouselDao.deleteById(id) > 0;
    }
}