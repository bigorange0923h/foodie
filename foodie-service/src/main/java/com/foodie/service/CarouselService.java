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
     * 获取所有轮播图
     * @param isShow
     * @return
     */
    public List<Carousel> queryAll(Integer isShow);
}