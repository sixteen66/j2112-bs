package com.qf.j2112.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
    private int goodsid;
    private int orderid;
    private String goodsstate;
    private String startsite;
    private String endsite;
    private Date sendtime;
    private float goodskg;
    private String goodsvm;
    private Date gettime;
}
