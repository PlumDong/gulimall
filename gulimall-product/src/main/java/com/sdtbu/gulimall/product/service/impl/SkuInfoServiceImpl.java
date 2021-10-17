package com.sdtbu.gulimall.product.service.impl;

import com.alibaba.nacos.client.utils.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdtbu.common.utils.PageUtils;
import com.sdtbu.common.utils.Query;

import com.sdtbu.gulimall.product.dao.SkuInfoDao;
import com.sdtbu.gulimall.product.entity.SkuInfoEntity;
import com.sdtbu.gulimall.product.service.SkuInfoService;


@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoDao, SkuInfoEntity> implements SkuInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                new QueryWrapper<SkuInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageByCondition(Map<String, Object> params) {
        QueryWrapper<SkuInfoEntity> wrapper = new QueryWrapper<>();
        String key = (String) params.get("key");
        String catelogId = (String) params.get("catelogId");
        String brandId = (String) params.get("brandId");
        String min = (String) params.get("min");
        String max = (String) params.get("max");
        if (! StringUtils.isEmpty(key)){
            wrapper.and( w -> {
                w.eq("sku_id",key).or().like("sku_name",key);
            });
        }
        if (! StringUtils.isEmpty(catelogId)){
            wrapper.eq("catalog_id",catelogId);
        }
        if (! StringUtils.isEmpty(brandId)){
            wrapper.eq("brand_id",brandId);
        }
        if (! StringUtils.isEmpty(min) &&
                ! "0".equalsIgnoreCase(min)){
            wrapper.gt("price",min);
        }
        if (! StringUtils.isEmpty(max) &&
                ! "0".equalsIgnoreCase(max)){
            wrapper.le("price",max);
        }
        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

}