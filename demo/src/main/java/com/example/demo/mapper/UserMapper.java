package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<Map<String,Object>> getAllUser();
    Map<String,Object> getUserById(@Param("id") int id);

}

