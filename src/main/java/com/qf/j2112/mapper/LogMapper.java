package com.qf.j2112.mapper;

import com.qf.j2112.po.BsLog;
import com.qf.j2112.vo.LogInfo;
import sun.rmi.runtime.Log;

import java.util.List;

public interface LogMapper {

    int addLog(BsLog log);

    List<BsLog> findAll();

    List<BsLog> findLogByInfo(LogInfo info);


}
