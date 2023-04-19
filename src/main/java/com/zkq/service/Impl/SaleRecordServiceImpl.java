package com.zkq.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkq.mapper.SaleRecordMapper;
import com.zkq.pojo.SaleRecord;
import com.zkq.service.SaleRecordService;
import org.springframework.stereotype.Service;

@Service
public class SaleRecordServiceImpl extends ServiceImpl<SaleRecordMapper, SaleRecord> implements SaleRecordService {
}
