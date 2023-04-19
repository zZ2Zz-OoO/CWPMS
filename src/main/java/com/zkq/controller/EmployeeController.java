package com.zkq.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zkq.pojo.Employee;
import com.zkq.pojo.Manager;
import com.zkq.pojo.Result;
import com.zkq.service.EmployeeService;
import com.zkq.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/login")
    public Result<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {


        String password = DigestUtils.md5DigestAsHex(employee.getPassword().getBytes());

        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", employee.getUserName());
        Employee one = service.getOne(queryWrapper);

        if (one == null) {
            return Result.error("登录失败");
        }
        if (!one.getPassword().equals(password)) {
            return Result.error("登陆失败");
        }

        request.getSession().setAttribute("employee", one.getUserName());
        Employee employee1 = new Employee();
        employee1.setUserId(one.getUserId());
        employee1.setUserName(one.getUserName());
        return Result.success(employee);
    }


    @PostMapping
    public Result<String> addUser(@RequestBody Employee employee) {

        employee.setPassword(DigestUtils.md5DigestAsHex(employee.getPassword().getBytes()));
        service.save(employee);
        return Result.success("新增用户成功");

    }

    @GetMapping("/{user_id}")
    public Result<Employee> getById(@PathVariable Integer user_id) {
        Employee employee = service.getById(user_id);
        if (employee != null) {
            return Result.success(employee);
        }
        return Result.error("没有查询到此员工");
    }

    @GetMapping
    public Result<List<Employee>> getAll() {
        List<Employee> employees = service.list();
        return Result.success(employees);
    }

    @PutMapping
    public Result<String> update(@RequestBody Employee employee) {
        boolean flag = service.updateById(employee);
        if (flag) {
            return Result.success("修改成功");
        }
        else {
            return Result.error("修改失败");
        }
    }

    @DeleteMapping("/{user_id}")
    public Result<String> delete(@PathVariable Integer user_id) {
        boolean b = service.removeById(user_id);
        if (b) {
            return Result.success("删除成功");
        }
        else {
            return Result.error("删除失败");
        }
    }

    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("employee"));
        if (request.getSession().getAttribute("employee") == null) {

            return Result.error("请勿重复退出");
        }
        else {
            request.getSession().removeAttribute("manager");
            return Result.success("退出成功");
        }
    }
}
