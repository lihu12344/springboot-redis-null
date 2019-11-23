package com.example.demo.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.demo.dao")
public class DataConfig {

    @Bean
    public PaginationInterceptor initPaginationInterceptor(){
        return new PaginationInterceptor();
    }

    @Bean
    public OptimisticLockerInterceptor initOptimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

}
