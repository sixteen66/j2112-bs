package com.qf.j2112.mapper;

import com.qf.j2112.po.Notice;

import java.util.List;

public interface NoticeMapper {
    Notice findNotice();

    int updateNotice();

    int addNotice(Notice notice);
}
