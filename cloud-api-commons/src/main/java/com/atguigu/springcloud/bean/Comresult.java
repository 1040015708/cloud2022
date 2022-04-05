package com.atguigu.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comresult<T> {
    private Integer code;
    private String message;
    private T data;

    public Comresult(Integer code, String message){
        this(code,message,null);
    }
}
