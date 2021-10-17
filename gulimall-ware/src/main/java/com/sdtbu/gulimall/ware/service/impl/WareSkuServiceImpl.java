package com.sdtbu.gulimall.ware.service.impl;

import com.alibaba.nacos.client.utils.StringUtils;
import com.sdtbu.common.utils.R;
import com.sdtbu.gulimall.ware.feign.ProductFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdtbu.common.utils.PageUtils;
import com.sdtbu.common.utils.Query;

import com.sdtbu.gulimall.ware.dao.WareSkuDao;
import com.sdtbu.gulimall.ware.entity.WareSkuEntity;
import com.sdtbu.gulimall.ware.service.WareSkuService;


@Service("wareSkuService")
public class WareSkuServiceImpl extends ServiceImpl<WareSkuDao, WareSkuEntity> implements WareSkuService {

    @Autowired
    ProductFeignService productFeignService;
    @Autowired
    WareSkuDao wareSkuDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<WareSkuEntity> wrapper = new QueryWrapper<>();
        String skuId = (String) params.get("skuId");
        if (!StringUtils.isEmpty(skuId)){
            wrapper.eq("sku_id",skuId);
        }
        String wareId = (String) params.get("wareId");
        if (!StringUtils.isEmpty(wareId)){
            wrapper.eq("ware_id",wareId);
        }


        IPage<WareSkuEntity> page = this.page(
                new Query<WareSkuEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void addStock(Long skuId, Long wareId, Integer skuNum) {
        // 判断如果没有这个库存记录，则新增
        List<WareSkuEntity> wareSkuEntities = wareSkuDao.selectList(new QueryWrapper<WareSkuEntity>().eq("sku_id", skuId).eq("ware_id", wareId));
        if (wareSkuEntities == null || wareSkuEntities.size() == 0){
            WareSkuEntity skuEntity = new WareSkuEntity();
            skuEntity.setSkuId(skuId);
            skuEntity.setStock(skuNum);
            skuEntity.setWareId(wareId);
            skuEntity.setStock(0);
            //TODO 远程查询sku的名字  如果失败，无需事务回滚
            //通过捕获异常的方式防止事务回滚，其他方式？
            try {
                R info = productFeignService.info(skuId);
                Map<String,Object> map = (Map<String, Object>) info.get("skuInfo");
                if (info.getCode() == 0){
                    skuEntity.setSkuName((String) map.get("skuName"));
                }
            }catch (Exception e){

            }

            wareSkuDao.insert(skuEntity);
        }else {
            wareSkuDao.addStock(skuId,wareId,skuNum);
        }

    }

}