package com.zkq.pojo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result<T> {
    private Integer CODE;//1为成功其他为失败
    private String msg;
    private T data;
    private Map map = new HashMap();

    public static <T> Result<T> success(T obj) {
        Result<T> tr = new Result<>();
        tr.data = obj;
        tr.CODE = 1;
        return tr;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> tr = new Result<>();
        tr.CODE = -1;
        tr.msg = msg;
        return tr;
    }

    public Result<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
