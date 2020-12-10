package com.sdtbu.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdtbu.common.utils.PageUtils;
import com.sdtbu.gulimall.ware.entity.WareOrderTaskDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author mazhendong
 * @email 1695165447@qq.com
 * @date 2020-12-09 10:24:57
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

