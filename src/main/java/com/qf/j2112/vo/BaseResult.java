package com.qf.j2112.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult implements Serializable {
    private Integer code;
    private String msg;
    private Object data;
}
