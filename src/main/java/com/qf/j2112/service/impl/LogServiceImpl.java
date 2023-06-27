package com.qf.j2112.service.impl;

import com.qf.j2112.mapper.LogMapper;
import com.qf.j2112.po.BsLog;
import com.qf.j2112.service.LogService;
import com.qf.j2112.vo.LogInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Resource
    LogMapper logMapper;
    @Override
    public boolean addLogg(BsLog log) {
        int i = logMapper.addLog(log);
        if (i>-1) return true;
        return false;
    }

    @Override
    public List<BsLog> findAll() {
        List<BsLog> all = logMapper.findAll();
        return all;
    }

    @Override
    public List<BsLog> findLogByInfo(LogInfo info) {
        List<BsLog> logByInfo = logMapper.findLogByInfo(info);
        return logByInfo;
    }
}
