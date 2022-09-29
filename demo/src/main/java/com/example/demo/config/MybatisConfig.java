package com.example.demo.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.example.demo.custom.CustomSqlInjector;
import com.example.demo.handler.SqlLogsInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@MapperScan("com.example.demo.mapper")
public class MybatisConfig {


    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 自定义拦截器，先添加先执行。
        interceptor.addInnerInterceptor(new SqlLogsInterceptor());
        return interceptor;
    }

//    @Bean
//    public CustomSqlInjector myLogicSqlInjector() {
//        System.out.println("CustomSqlInjector.myLogicSqlInjector");
//        return new CustomSqlInjector();
//    }
}
