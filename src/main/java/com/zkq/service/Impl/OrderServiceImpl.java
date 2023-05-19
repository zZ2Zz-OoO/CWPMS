package com.zkq.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkq.mapper.OrderMapper;
import com.zkq.pojo.Orders;
import com.zkq.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {
}
