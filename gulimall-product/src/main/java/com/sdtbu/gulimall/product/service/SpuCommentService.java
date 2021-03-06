package com.sdtbu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdtbu.common.utils.PageUtils;
import com.sdtbu.gulimall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author mazhendong
 * @email 1695165447@qq.com
 * @date 2020-12-09 10:21:06
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

