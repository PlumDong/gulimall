package com.sdtbu.gulimall.ware.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.sdtbu.gulimall.ware.dao")
@Configuration
public class WareMyBatisConfig {
    //引入分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor pagina = new PaginationInterceptor();
        pagina.setOverflow(true);
        pagina.setLimit(500);
        return pagina;
    }
}
