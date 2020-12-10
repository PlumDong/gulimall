package com.sdtbu.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdtbu.common.utils.PageUtils;
import com.sdtbu.gulimall.member.entity.GrowthChangeHistoryEntity;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author mazhendong
 * @email 1695165447@qq.com
 * @date 2020-12-08 15:12:23
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

