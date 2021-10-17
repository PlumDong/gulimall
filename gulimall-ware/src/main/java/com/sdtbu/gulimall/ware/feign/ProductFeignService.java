package com.sdtbu.gulimall.ware.feign;

import com.sdtbu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gulimall-product")
public interface ProductFeignService {
    /**
     *      1. 让所有请求过一下网关
     *          @FeignClient("gulimall-gateway")
     *          /api/product/skuinfo/info/{skuId}
     *      2. 直接让后台指定服务处理
     *          @FeignClient("gulimall-product")
     *          /product/skuinfo/info/{skuId}
     *
     */
    @RequestMapping("/product/skuinfo/info/{skuId}")
    public R info(@PathVariable("skuId") Long skuId);
}
