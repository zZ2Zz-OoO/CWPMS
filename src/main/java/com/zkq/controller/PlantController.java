package com.zkq.controller;

import com.zkq.pojo.Plant;
import com.zkq.pojo.Result;
import com.zkq.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("plants")
public class PlantController {
    @Autowired
    private PlantService service;

    @PostMapping
    public Result<String> addServiceType(@RequestBody Plant plant) {
        boolean save = service.save(plant);
        if (save) {
            return Result.success("添加种类成功");
        }
        else {
            return Result.error("添加种类失败");
        }
    }

    @DeleteMapping("/{plant_id}")
    public Result<String> deleteOne(@PathVariable BigInteger plant_id) {
        boolean b = service.removeById(plant_id);
        if (b) {
            return Result.success("删除成功");
        }
        else {
            return Result.error("删除失败");
        }
    }

    @GetMapping("/{plant_id}")
    public Result<Plant> getById(@PathVariable BigInteger plant_id) {
        Plant plant = service.getById(plant_id);
        if (plant != null) {
            return Result.success(plant);
        }
        return Result.error("无此种类");
    }

    @GetMapping
    public Result<List<Plant>> getAll() {
        List<Plant> serviceTypes = service.list();
        return Result.success(serviceTypes);
    }

    @PutMapping
    public Result<String> update(@RequestBody Plant plant) {
        boolean flag = service.updateById(plant);
        if (flag) {
            return Result.success("修改成功");
        }
        else {
            return Result.error("修改失败");
        }
    }
}
