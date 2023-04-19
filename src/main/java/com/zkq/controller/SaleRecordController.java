package com.zkq.controller;

import com.zkq.pojo.Plant;
import com.zkq.pojo.Result;
import com.zkq.pojo.SaleRecord;
import com.zkq.service.PlantService;
import com.zkq.service.SaleRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("sales")
public class SaleRecordController {
    @Autowired
    private SaleRecordService service;

    @PostMapping
    public Result<String> addServiceType(@RequestBody SaleRecord saleRecord) {
        boolean save = service.save(saleRecord);
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
    public Result<SaleRecord> getById(@PathVariable BigInteger record_id) {
        SaleRecord saleRecord = service.getById(record_id);
        if (saleRecord != null) {
            return Result.success(saleRecord);
        }
        return Result.error("无此种类");
    }

    @GetMapping
    public Result<List<SaleRecord>> getAll() {
        List<SaleRecord> saleRecords = service.list();
        return Result.success(saleRecords);
    }

    @PutMapping
    public Result<String> update(@RequestBody SaleRecord saleRecord) {
        boolean flag = service.updateById(saleRecord);
        if (flag) {
            return Result.success("修改成功");
        }
        else {
            return Result.error("修改失败");
        }
    }
}
