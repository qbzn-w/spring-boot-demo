package com.example.demo.service;

import com.example.demo.bean.BulidMapResult;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
// 设置名称
@Service("UserService")

public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private  RedisUtil redisUtil;

    public Map<String,Object> getUserNameById(String id){

        if (!StringUtils.isNumeric(id)){
            return BulidMapResult.errorResult("not find",null);
        }
        Map<String,Object>  resultMap=userMapper.getUserById(Integer.parseInt(id));
        if (resultMap!=null){
            return BulidMapResult.okResult(resultMap);
        }

        return BulidMapResult.errorResult("not find",resultMap);

    }
    public Map<String,Object> getAllUser(){
        List<Map<String,Object>>  resultMap=userMapper.getAllUser();

            return BulidMapResult.okResult(resultMap);

    }
}
