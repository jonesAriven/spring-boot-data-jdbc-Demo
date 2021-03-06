package com.swdeve.springBoot.controller;

import com.swdeve.springBoot.entity.User;
import com.swdeve.springBoot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过JPA操作数据库
 */
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}") //浏览器端访问地址：http://localhost:8080/user/2
    public User getUser(@PathVariable("id") Integer id){
        User user = userRepository.findOne(id);
        return user;
    }

    @GetMapping("/user")//浏览器端访问地址：http://localhost:8080/user?lastName=lishi&email=1750163946@qq.com&gender=1&dId=2
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }

}
