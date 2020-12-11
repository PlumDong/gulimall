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
	@RefreshScoppe
 	@Value

 */

@EnableDiscoveryClient
@SpringBootApplication
public class GulimallCouponApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallCouponApplication.class, args);
	}

}
