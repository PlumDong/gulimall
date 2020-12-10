package com.sdtbu.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdtbu.common.utils.PageUtils;
import com.sdtbu.gulimall.member.entity.MemberStatisticsInfoEntity;

import java.util.Map;

/**
 * 会员统计信息
 *
 * @author mazhendong
 * @email 1695165447@qq.com
 * @date 2020-12-08 15:12:22
 */
public interface MemberStatisticsInfoService extends IService<MemberStatisticsInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

