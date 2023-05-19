package com.zkq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.org.apache.xpath.internal.objects.XString;
import lombok.Data;

@Data
public class ApplicationRecord {
    @TableId(value = "record_id",type = IdType.ASSIGN_ID)
    private Integer recordId;
    private Integer plantId;
    private String plantName;
    private double price;
    private String time;
    private String employeeName;
    private Integer isAllowed;
    private Integer isRefused;
    private Integer quantity;
    private String destination;
}
