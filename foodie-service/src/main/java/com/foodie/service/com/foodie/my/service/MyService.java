package com.foodie.service.com.foodie.my.service;

import com.foodie.utils.PagedGridResult;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class MyService {

    /**
     * 公用分页转换
     * @param list
     * @param page
     * @return
     */
    public PagedGridResult setterPagedGrid(List<?> list, Integer page){
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(list);
        grid.setTotal(pageList.getPages());
        grid.setRecords(pageList.getTotal());
        return  grid;
    }

}
