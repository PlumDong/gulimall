package com.sdtbu.gulimall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
		4). 分组校验
 			1. @NotBlank(message = "品牌名不能为空",groups = {AddGroup.class,UpdateGroup.class})
				校验注解标注什么情况下需要进行校验
			2. @Validated({AddGroup.class})
 			3. 默认没有指定分组的校验注解@NotBlank, 在分组校验情况下不生效
 		5). 自定义校验
 			1. 编写一个自定义的校验注解
 			2. 编译一个自定义的校验器    	ConstraintValidator
 			3.关联自定义的校验器和自定义的校验注解
				 @Documented
				 @Constraint(validatedBy = { ListValueConstraintValidator.class （可以指定多个不同的校验器，适配不同类型的校验） })
				 @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
				 @Retention(RUNTIME)


 	4.统一的异常处理
 		@ControllerAdvice
 */
@EnableFeignClients(basePackages = "com.sdtbu.gulimall.product.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallProductApplication.class, args);
	}

}
