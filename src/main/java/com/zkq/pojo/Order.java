package com.zkq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Order {
    @TableId(value = "order_id",type = IdType.ASSIGN_ID)
    private Integer orderId;
    private Integer plantId;
    private String orderTime;
    private Integer orderStatus;
    private Integer deliveryStatus;
    private Integer courierNumber;
    private Integer managerId;
    private Integer userId;
    private String phone;
    private String address;
    private double totalPrice;
}
