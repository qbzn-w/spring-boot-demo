package com.example.demo.controller;

import com.example.demo.service.AsyncService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
//    指定名称注入,如果没多个可以不注入
    private AsyncService asyncService;
    @Autowired
    @Qualifier("UserService")
//    指定名称注入,如果没多个可以不注入
    private UserService userService;

    @PostMapping("/getNameById")

    public Object getUser(HttpServletRequest request){
      String id = request.getParameter("id");
      asyncService.hello();
      return userService.getUserNameById(id);

    }


}
