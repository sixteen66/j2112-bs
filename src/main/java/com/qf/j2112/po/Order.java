package com.qf.j2112.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private int orderid;
    private String ordername;
    private Date ordertime;
    private String ordertel;
    private String orderstate;
    private String startsite;
    private String endsite;
    private String comname;
    private String recname;
    private String recaddr;
    private String rectel;
    private String orderprice;
}
