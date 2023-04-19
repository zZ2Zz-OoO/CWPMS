package com.zkq.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkq.mapper.PlantMapper;
import com.zkq.pojo.Plant;
import com.zkq.service.PlantService;
import org.springframework.stereotype.Service;

@Service
public class PlantServiceImpl extends ServiceImpl<PlantMapper, Plant> implements PlantService {
}
