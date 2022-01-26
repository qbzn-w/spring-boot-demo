package com.example.demo.interceptors;

import com.example.demo.bean.BulidMapResult;
import com.example.demo.pojo.User;
import com.example.demo.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginInterceptor  implements HandlerInterceptor {
    @Autowired
    private User user;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getParameter("token");

        System.out.println("拦截器启动成功:拦截了:"+request.getRequestURI());

        if (StringUtils.isEmpty(token)){

            String json= JsonUtils.objectToJson(BulidMapResult.errorResult("token is empty ",null));
            returnJson(response,json);
            return false;
        }else {
            return true;
        }
    }


    private void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
            System.out.println("error");
        } finally {
            if (writer != null)
                writer.close();
        }
    }


}
