package com.qf.j2112.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BsLog implements Serializable {
    private int logId;
    private String logName;
    private String realname;
    private Date logTime;
    private String userIp;
    private int logUserId;
}
