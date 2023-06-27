package com.qf.j2112.service.impl;

import com.qf.j2112.mapper.NoticeMapper;
import com.qf.j2112.po.Notice;
import com.qf.j2112.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    NoticeMapper noticeMapper;
    @Override
    public Notice findNotice() {
        Notice all = noticeMapper.findNotice();
        return all;
    }

    @Override
    public int updateNotice() {
        int i = noticeMapper.updateNotice();

        return i;
    }

    @Override
    public int addNotice(Notice notice) {
        int i=noticeMapper.addNotice(notice);
        return i;
    }
}
