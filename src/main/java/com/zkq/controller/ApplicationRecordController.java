package com.zkq.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zkq.pojo.Result;
import com.zkq.pojo.ApplicationRecord;
import com.zkq.service.ApplicationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("applications")
public class ApplicationRecordController {
    @Autowired
    private ApplicationRecordService service;

    @PostMapping
    public Result<String> addApplication(@RequestBody ApplicationRecord applicationRecord) {
        boolean save = service.save(applicationRecord);
        if (save) {
            return Result.success("添加成功");
        }
        else {
            return Result.error("添加失败");
        }
    }

    @DeleteMapping("/{record_id}")
    public Result<String> deleteOne(@PathVariable Integer record_id) {
        boolean b = service.removeById(record_id);
        if (b) {
            return Result.success("删除成功");
        }
        else {
            return Result.error("删除失败");
        }
    }

    @GetMapping("/{record_id}")
    public Result<ApplicationRecord> getById(@PathVariable BigInteger record_id) {
        ApplicationRecord applicationRecord = service.getById(record_id);
        if (applicationRecord != null) {
            return Result.success(applicationRecord);
        }
        return Result.error("无此种类");
    }

    @GetMapping("/application")
    public Result<List<ApplicationRecord>> getApplications() {
        QueryWrapper<ApplicationRecord> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("is_allowed","0")
                    .eq("is_refused","0");

        List<ApplicationRecord> records = service.list(QueryWrapper);
        if (records==null){
            return Result.error("暂无记录");
        }
        System.out.println(records);
        return Result.success(records);
    }

    @GetMapping
    public Result<List<ApplicationRecord>> getAll() {
        List<ApplicationRecord> applicationRecords = service.list();
        return Result.success(applicationRecords);
    }
    @GetMapping("/application/{employee_name}")
    public Result<List<ApplicationRecord>> getByEmployee(@PathVariable String employee_name) {
        QueryWrapper<ApplicationRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_name",employee_name);
        List<ApplicationRecord> applicationRecords = service.list(queryWrapper);
        return Result.success(applicationRecords);
    }

    @PutMapping
    public Result<String> update(@RequestBody ApplicationRecord applicationRecord) {
        boolean flag = service.updateById(applicationRecord);
        if (flag) {
            return Result.success("批准成功");
        }
        else {
            return Result.error("批准失败");
        }
    }
}
