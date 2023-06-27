package com.qf.j2112.mapper;

import com.qf.j2112.po.Site;

import java.util.List;

public interface SiteMapper {

    List<Site> findAll();

    int updateSite(Site site);

    int delSite(Site site);

    List<Site> findBySite(Site site);

    int addSite(Site site);
}
