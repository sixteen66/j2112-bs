package com.qf.j2112.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Site implements Serializable {
    private int siteId;
    private String siteName;
    private String siteAddr;
    private String siteTel;
    private String sitePerson;
}
