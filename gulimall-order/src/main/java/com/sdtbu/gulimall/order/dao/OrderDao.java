package com.sdtbu.gulimall.order.dao;

import com.sdtbu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author mazhendong
 * @email 1695165447@qq.com
 * @date 2020-12-09 10:17:53
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
