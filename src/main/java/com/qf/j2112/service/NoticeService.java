package com.qf.j2112.service;

import com.qf.j2112.po.Notice;

import java.util.List;

public interface NoticeService {
    Notice findNotice();

    int updateNotice();

    int addNotice(Notice notice);
}
