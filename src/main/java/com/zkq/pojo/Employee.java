package com.zkq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Employee {
    @TableId(value = "user_id",type= IdType.ASSIGN_ID)
    private Integer userId;
    private String userName;
    private String password;
    private String phone;
    private String email;
    private String createTime;
}
