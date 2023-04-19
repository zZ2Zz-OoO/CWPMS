package com.zkq.controller;

import com.zkq.pojo.Order;
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
    public Result<String> addServiceType(@RequestBody Order order) {
        boolean save = service.save(order);
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
    public Result<Order> getById(@PathVariable Integer order_id) {
        Order order = service.getById(order_id);
        if (order != null) {
            return Result.success(order);
        }
        return Result.error("无此种类");
    }

    @GetMapping
    public Result<List<Order>> getAll() {
        List<Order> orders = service.list();
        return Result.success(orders);
    }

    @PutMapping
    public Result<String> update(@RequestBody Order order) {
        boolean flag = service.updateById(order);
        if (flag) {
            return Result.success("修改成功");
        }
        else {
            return Result.error("修改失败");
        }
    }
}
