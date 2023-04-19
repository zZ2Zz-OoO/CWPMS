package com.zkq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Value;

@Data
public class Manager {
    @TableId(value="manager_id",type = IdType.ASSIGN_ID)
    private Integer managerId;
    private String userName;
    private String password;
    private String companyName;
}
