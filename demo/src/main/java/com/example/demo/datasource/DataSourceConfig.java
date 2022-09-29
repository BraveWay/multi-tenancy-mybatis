package com.example.demo.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;


@Configuration
public class DataSourceConfig {


    /**
     *
     * Primary 指定默认的数据源
     * DependsOn 加载admin数据源
     *
     *
     **/
    @Bean("master")
    @ConfigurationProperties(prefix = "spring.datasource.default")
    public DataSource defaultDataSource() {
        DataSource ds = DataSourceBuilder.create().build();
        TenantDataSourceProvider.dataSourceMap.put("default",ds);
//        RoutingDataSource routingDataSource = new RoutingDataSource();
//        routingDataSource.setTargetDataSources(TenantDataSourceProvider.dataSourceMap);
        return ds;
    }

    @Bean("admin")
    @ConfigurationProperties(prefix = "spring.datasource.admin")
    public DataSource adminDataSource() {
        DataSource ds = DataSourceBuilder.create().build();
        TenantDataSourceProvider.dataSourceMap.put("admin",ds);
        return ds;
    }

    //@Qualifier类型相同时，根据名称进行注入
    @Bean
    @Primary//三个方法返回类型相同，以此方法返回为主
    public DataSource primaryDataSource(
            @Autowired @Qualifier("master") DataSource masterDataSourve,
            @Autowired @Qualifier("admin") DataSource adminDataSource
    ){
        RoutingDataSource routingDataSource = new RoutingDataSource();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("master",masterDataSourve);
        map.put("admin",adminDataSource);
        map.put("ds2",this.ds2());
        map.put("ds3",this.ds3());
        routingDataSource.setTargetDataSources(map);
        return routingDataSource;
    }

    private DataSource ds2(){
        HikariDataSource dataSource = new HikariDataSource();
        ////设置数据源
        String jdbcUrl = "jdbc:mysql://localhost:3306/saas-test2?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&nullCatalogMeansCurrent=true";
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername("root");
        dataSource.setPassword("saasdev");
        return dataSource;
    }



    private DataSource ds3(){
        HikariDataSource dataSource = new HikariDataSource();
        ////设置数据源
        String jdbcUrl = "jdbc:mysql://localhost:3306/saas-test3?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&nullCatalogMeansCurrent=true";
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername("root");
        dataSource.setPassword("saasdev");
        return dataSource;
    }

}
