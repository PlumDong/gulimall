package com.sdtbu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdtbu.common.utils.PageUtils;
import com.sdtbu.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author mazhendong
 * @email 1695165447@qq.com
 * @date 2020-12-09 10:21:06
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTre();

    void removeMenuByIds(List<Long> asList);

    public Long[] findCatelogPath(Long catelogId);

    void updateCascade(CategoryEntity category);
}

