package com.example.demo.custom;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * @Author: YEJUN
 * @CreateTime: 2022-08-24  17:48
 * @Description: TODO
 * @Version: 1.0
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {

    int updateIncome(@Param(Constants.ENTITY) T entity);

}
