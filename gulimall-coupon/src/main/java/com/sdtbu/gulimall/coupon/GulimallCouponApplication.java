package com.sdtbu.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/***
1. 引入依赖
	<dependency>
	 <groupId>com.alibaba.cloud</groupId>
	 <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
	</dependency>

2. 创建一个bootstrap.properties。内容为
	 spring.application.name=gulimall-coupon
	 spring.cloud.nacos.config.server-addr=127.0.0.1:8848
3. 需要给配置中心默认添加一个叫数据集（Data Id) guLimaLl-coupon,properties。默认规则，应用名.
4. 给应用名.properties添加任何配置
5. 动态获取配置，给相应的	Controller	添加注解
	@RefreshScope				用于动态获取并刷新配置
 	@Value("${配置项的名称}")		用于获取配置
	如果在配置中心和当前应用的配置文件中和都配置了相同的项，优先使用配置中心的配置

每个微服务创建自己的命名空间，使用配置分组管理需要在不同环境下使用的文件
	命名空间ID：spring.cloud.nacos.config.namespace=eb3a1b4e-8aeb-4c6c-afb3-913d1f7e40b9
	分组选择：spring.cloud.nacos.config.group=DEFAULT_GROUP

	选择不同的配置文件：

 */


@EnableDiscoveryClient
@SpringBootApplication
public class GulimallCouponApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallCouponApplication.class, args);
	}

}
