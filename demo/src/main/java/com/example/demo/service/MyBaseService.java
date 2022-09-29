package com.example.demo.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: YEJUN
 * @CreateTime: 2022-08-26  11:41
 * @Description: TODO
 * @Version: 1.0
 */
public class MyBaseService<M extends BaseMapper<T>, T> {

    protected Log log = LogFactory.getLog(getClass());


}
