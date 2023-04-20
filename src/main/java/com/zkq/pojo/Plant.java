package com.zkq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Plant {
    @TableId(value = "plant_id",type = IdType.ASSIGN_ID)
    private Integer plantId;
    private String  plantName;
    private String  plantInfo;
    private String  plantFunction;
    private String  plantType;
    private Integer price;
    private Integer advicePh;
    private Integer quantity;
}
