package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoMybatisApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserService userService;


	@Test
	void contextLoads() {
//		User user = userMapper.selectById(11850966);
//		System.out.println(user.getAddress());
//		userService.test(11848987L,200);
		User user = new User();
		user.setId(11848987L);
		user.setIncome(5000);
		UpdateWrapper wrapper = new UpdateWrapper();
		userMapper.updateIncome(user);
	}

	@Test
	void contextLoads2() {
		User user = new User();
		user.setId(11848987L);
		UpdateWrapper<User> wrapper = new UpdateWrapper<User>();
		wrapper.eq("id",11848987L);
		wrapper.setSql(" income = income + 1");
		userMapper.update(null,wrapper);
	}

}
