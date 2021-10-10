package com.sdtbu.gulimall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
  	1、整合MyBatis-Plus
		1）、导入依赖
			<dependency>
			  <groupId>com.baomidou</groupId>
			  <artifactId>mybatis-plus-boot-starter</artifactId>
			  <version>3.3.1</version>
		  	</dependency>
		2）、配置数据源等相关信息
		在 application.yml 文件中添加相关信息

	2、逻辑删除
	1）、配置 application.yml 文件中
	mybatis-plus:
			global-config:
				db-config:
					id-type:auto
					logic-delete-value:1
					logic-not-delete-value:0
		2）、实体类字段上加上@TableLogic注解

 	3.JSR303校验
 		1). 给bean添加校验注解  注解参考包：javax.validation.constraints
 		2). 开启校验功能@valid 效果 校验错误后会有默认响应
 		3). 给校验的bean后紧跟一个bindingResult，就可以获取到校验的结果

 	4.统一的异常处理
 		@ControllerAdvice
 */

@EnableDiscoveryClient
@SpringBootApplication
public class GulimallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallProductApplication.class, args);
	}

}
