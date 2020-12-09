package com.example.redisdemo.controller;

import com.example.redisdemo.POJO.User;
import com.example.redisdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class redisController {
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/set")
    @ResponseBody
    public String set(){
        try {
            User user = new User("张三","12");
            redisUtil.set(user.getName(), user.getAge());
            return (String) redisUtil.get(user.getName());
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
