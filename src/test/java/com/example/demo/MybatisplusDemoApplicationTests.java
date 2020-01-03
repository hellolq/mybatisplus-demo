package com.example.demo;


import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisplusDemoApplicationTests {

	private final static Logger logger = LoggerFactory.getLogger(MybatisplusDemoApplicationTests.class);
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void test1(){
		List<User> list = userService.list();
		logger.info(list.toString());
	}
}
