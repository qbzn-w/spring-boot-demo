package com.example.demo.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BulidMapResult {
  private   static Map<String,Object>  getMapResult(int code,Map<String,Object> resultMap,String msg ){
      Map<String,Object> map = new HashMap<>();
      map.put("code",code);
      map.put("data",resultMap);
      map.put("msg",msg);
      return map;
  }
    private   static Map<String,Object>  getMapResult(int code,List<Map<String,Object> >resultMap,String msg ){
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("data",resultMap);
        map.put("msg",msg);
        return map;
    }
  public static  Map<String,Object> okResult(Map<String,Object> resultMap){
      return getMapResult(0,resultMap,"success");
  }
    public static  Map<String,Object> okResult(List<Map<String, Object>> resultMap){
        return getMapResult(0,resultMap,"success");
    }
    public static  Map<String,Object> errorResult(String msg,Map<String,Object> resultMap){
        return getMapResult(200,resultMap,msg);
    }
}
