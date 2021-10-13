package com.sdtbu.gulimall.product.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement    //开启事务
@MapperScan("com.sdtbu.gulimall.product.dao")
public class MyBatisConfig {

    //引入分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor pagina = new PaginationInterceptor();
        pagina.setOverflow(true);
        pagina.setLimit(500);
        return pagina;
    }


}
