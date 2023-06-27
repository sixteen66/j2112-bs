package com.qf.j2112.service;

import com.qf.j2112.po.BsLog;
import com.qf.j2112.vo.LogInfo;

import java.util.List;

public interface LogService {

    boolean addLogg(BsLog log);

    List<BsLog> findAll();

    List<BsLog> findLogByInfo(LogInfo info);
}
