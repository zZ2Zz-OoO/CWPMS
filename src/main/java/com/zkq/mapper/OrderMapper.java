package com.zkq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zkq.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
