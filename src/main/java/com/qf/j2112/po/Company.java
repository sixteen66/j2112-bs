package com.qf.j2112.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {
    private int comid;
    private String comname;
    private String cominterduction;
    private String comtel;
    private String comprice;
    private String comaddr;
}
