package com.zkq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Orders {
    @TableId(value = "order_id",type = IdType.ASSIGN_ID)
    private Integer orderId;
    private String employeeName;
    private String orderTime;
    private Integer recordId;
    private Integer managerId;
    private String phone;
    private String destination;
    private double totalPrice;
    private String plantName;
}
