package com.foodie.service.impl;

import com.foodie.mapper.CategoryMapper;
import com.foodie.mapper.CategoryMapperCustom;
import com.foodie.pojo.Category;
import com.foodie.pojo.vo.CategoryVO;
import com.foodie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 商品分类(Category)表服务实现类
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryMapperCustom categoryMapperCustom;



    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Category>  queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type",1);
        return  categoryMapper.selectByExample(example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        return categoryMapperCustom.getSubCatList(rootCatId);

    }
}