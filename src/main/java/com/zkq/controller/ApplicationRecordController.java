package com.zkq.controller;

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
    public Result<String> addServiceType(@RequestBody ApplicationRecord applicationRecord) {
        boolean save = service.save(applicationRecord);
        if (save) {
            return Result.success("添加种类成功");
        }
        else {
            return Result.error("添加种类失败");
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

    @GetMapping
    public Result<List<ApplicationRecord>> getAll() {
        List<ApplicationRecord> applicationRecords = service.list();
        return Result.success(applicationRecords);
    }

    @PutMapping
    public Result<String> update(@RequestBody ApplicationRecord applicationRecord) {
        boolean flag = service.updateById(applicationRecord);
        if (flag) {
            return Result.success("修改成功");
        }
        else {
            return Result.error("修改失败");
        }
    }
}
