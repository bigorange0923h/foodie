package com.foodie.mapper;

import com.foodie.my.mapper.MyMapper;
import com.foodie.pojo.ItemsSpec;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsSpecMapper extends MyMapper<ItemsSpec> {


    int decreaseItemSpecStock(@Param("specId") String specId,
                              @Param("pendingCounts") int pendingCounts);

}