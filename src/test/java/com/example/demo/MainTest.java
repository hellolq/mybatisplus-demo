package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by H1N1 on 2019-12-18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTest {

    @Autowired
    UserMapper _mapper;
    
    @Test
    public void test(){
        User user = new User();
        user.setId(1);
        User result = _mapper.selectById(user);
        System.out.println(result.toString());
    }
    
}
