package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    @Qualifier("UserService")
//    指定名称注入,如果没多个可以不注入
    private UserService userService;

    @PostMapping("/getNameById")

    public Object getUser(HttpServletRequest request){
      String id = request.getParameter("id");

      return userService.getUserNameById(id);

    }
    @PostMapping("/getAllUser")
    public Object getAllUser(HttpServletRequest request){

        return userService.getAllUser();

    }


}
