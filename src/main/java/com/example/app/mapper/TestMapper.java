package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface TestMapper {

    public int getTotal();
}
