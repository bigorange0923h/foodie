package com.foodie.service.impl;


import com.foodie.mapper.CarouselMapper;
import com.foodie.pojo.Carousel;
import com.foodie.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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

    @Autowired
    private CarouselMapper carouselMapper;
    @Override
    public List<Carousel> queryAll(Integer isShow) {
        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isShow",isShow);

        return carouselMapper.selectByExample(example);
    }
}