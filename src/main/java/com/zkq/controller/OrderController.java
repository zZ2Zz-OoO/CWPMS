package com.zkq.controller;

import com.zkq.pojo.Orders;
import com.zkq.pojo.Result;
import com.zkq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    public Result<String> addServiceType(@RequestBody Orders orders) {
        boolean save = service.save(orders);
        if (save) {
            return Result.success("添加种类成功");
        }
        else {
            return Result.error("添加种类失败");
        }
    }

    @DeleteMapping("/{order_id}")
    public Result<String> deleteOne(@PathVariable Integer order_id) {
        boolean b = service.removeById(order_id);
        if (b) {
            return Result.success("删除成功");
        }
        else {
            return Result.error("删除失败");
        }
    }

    @GetMapping("/{order_id}")
    public Result<Orders> getById(@PathVariable Integer order_id) {
        Orders orders = service.getById(order_id);
        if (orders != null) {
            return Result.success(orders);
        }
        return Result.error("无此种类");
    }

    @GetMapping
    public Result<List<Orders>> getAll() {
        List<Orders> orders = service.list();
        return Result.success(orders);
    }

    @PutMapping
    public Result<String> update(@RequestBody Orders orders) {
        boolean flag = service.updateById(orders);
        if (flag) {
            return Result.success("修改成功");
        }
        else {
            return Result.error("修改失败");
        }
    }
}
