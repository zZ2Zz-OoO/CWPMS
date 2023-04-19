package com.zkq.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zkq.pojo.Manager;
import com.zkq.pojo.Result;
import com.zkq.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("managers")
public class ManagerController {
    @Autowired
    private ManagerService service;

    @PostMapping("/login")
    public Result<Manager> login(HttpServletRequest request, @RequestBody Manager manager) {


        String password = DigestUtils.md5DigestAsHex(manager.getPassword().getBytes());

        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", manager.getUserName());
        Manager one = service.getOne(queryWrapper);

        if (one == null) {
            return Result.error("登录失败");
        }
        if (!one.getPassword().equals(password)) {
            return Result.error("登陆失败");
        }

        request.getSession().setAttribute("manager", one.getManagerId());
        Manager  user1 = new Manager();
        user1.setManagerId(one.getManagerId());
        user1.setUserName(one.getUserName());
        return Result.success(user1);
    }


    @PostMapping
    public Result<String> addUser(@RequestBody Manager manager) {

        manager.setPassword(DigestUtils.md5DigestAsHex(manager.getPassword().getBytes()));
        service.save(manager);
        return Result.success("新增用户成功");

    }

    @GetMapping("/{manager_id}")
    public Result<Manager> getById(@PathVariable Integer manager_id) {
        Manager manager = service.getById(manager_id);
        if (manager != null) {
            return Result.success(manager);
        }
        return Result.error("没有查询到此员工");
    }

    @GetMapping
    public Result<List<Manager>> getAll() {
        List<Manager> managers = service.list();
        return Result.success(managers);
    }

    @PutMapping
    public Result<String> update(@RequestBody Manager manager) {
        boolean flag = service.updateById(manager);
        if (flag) {
            return Result.success("修改成功");
        }
        else {
            return Result.error("修改失败");
        }
    }

    @DeleteMapping("/{manager_id}")
    public Result<String> delete(@PathVariable Integer manager_id) {
        boolean b = service.removeById(manager_id);
        if (b) {
            return Result.success("删除成功");
        }
        else {
            return Result.error("删除失败");
        }
    }

    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("manager"));
        if (request.getSession().getAttribute("manager")==null){

            return Result.error("请勿重复退出");
        }else {
            request.getSession().removeAttribute("manager");
            return Result.success("退出成功");
        }
    }
}
