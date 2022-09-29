package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: YEJUN
 * @CreateTime: 2022-08-24  15:17
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public void updateIncome(float income,Long id){
        userMapper.updateIncome(null);
    }

    public void updateIncome2(Long id,float income){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id);
        User user = new User();
        user.setIncome(income);
        userMapper.update(null, updateWrapper);
    }

    @Override
    public  void test(Long id,float income){
        User user = userMapper.selectById(id);
        System.out.println(user);
        this.updateIncome2(id,income);
        System.out.println(user);
//        System.out.println(userMapper.selectById(id));
    }
}
