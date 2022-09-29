package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @Author: YEJUN
 * @CreateTime: 2022-08-24  10:25
 * @Description: TODO
 * @Version: 1.0
 */

public interface UserService  {

     void updateIncome(float income,Long id);

    void updateIncome2(Long id,float income);

    void test(Long id,float income);

}
