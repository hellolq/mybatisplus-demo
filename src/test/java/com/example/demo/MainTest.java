package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by H1N1 on 2019-12-18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTest {

    private final static Logger logger = LoggerFactory.getLogger(MainTest.class);

    @Autowired
    UserMapper _mapper;

    @Autowired
    private IUserService userService;

    @Test
    public void test2(){
        User aa = new User();
        Page<User> userPage = new Page<>(2,5);
        IPage<User> page = userService.page(userPage);
        logger.info(page.toString());
    }

    @Test
    public void test1(){
        User user = new User();
        //user.setId(1);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.setEntity(user);
        userQueryWrapper.eq("id",1);
        // userQueryWrapper.eq()
        List<User> list = userService.list(userQueryWrapper);
        logger.info("数量:{},详情:{}",list.size(),list.toString());
    }
    
    @Test
    public void test(){
        User user = new User();
        user.setId(1);
        User result = _mapper.selectById(user);
        System.out.println(result.toString());
    }
    
}
