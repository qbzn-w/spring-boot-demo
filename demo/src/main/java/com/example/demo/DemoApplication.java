package com.example.demo;

import com.example.demo.pojo.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync //开启异步注解
@EnableScheduling//开启定时任务注解
@MapperScan(basePackages = "com.example.demo.mapper")
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run =  SpringApplication.run(DemoApplication.class, args);
//		获取装配配置文件
		System.out.println(run.getBean("user", User.class).getId());
	}

}
