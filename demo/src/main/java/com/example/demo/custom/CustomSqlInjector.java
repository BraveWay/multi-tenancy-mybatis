package com.example.demo.custom;


import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class CustomSqlInjector extends DefaultSqlInjector {

    public List<AbstractMethod> getMethodList(Class<?> mapperClass,TableInfo tableInfo) {
        // 父类的list已经包含了BaseMapper的基础方法。
        List<AbstractMethod> methodList = super.getMethodList(mapperClass,tableInfo);
        // 添加我们需要增加的自定义方法。
        methodList.add(new UpdateIncome());
        return methodList;
    }


}

