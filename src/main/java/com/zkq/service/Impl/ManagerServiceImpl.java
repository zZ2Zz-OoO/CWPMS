package com.zkq.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkq.mapper.ManagerMapper;
import com.zkq.pojo.Manager;
import com.zkq.service.ManagerService;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {
}
