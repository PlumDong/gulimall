package com.sdtbu.gulimall.order.dao;

import com.sdtbu.gulimall.order.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author mazhendong
 * @email 1695165447@qq.com
 * @date 2020-12-09 10:17:53
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}
