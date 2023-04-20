package com.zkq.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkq.mapper.ApplicationRecordMapper;
import com.zkq.pojo.ApplicationRecord;
import com.zkq.service.ApplicationRecordService;
import org.springframework.stereotype.Service;

@Service
public class ApplicationRecordServiceImpl extends ServiceImpl<ApplicationRecordMapper, ApplicationRecord> implements ApplicationRecordService {
}
