package com.foodie.mapper;

import com.foodie.pojo.vo.CategoryVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapperCustom {

    public List<CategoryVO> getSubCatList(Integer rootCatId);
}