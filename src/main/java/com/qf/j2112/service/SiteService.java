package com.qf.j2112.service;

import com.qf.j2112.po.Site;

import java.util.List;

public interface SiteService {
    List<Site> findAll();

    boolean updateSite(Site site);

    boolean delSite(Site site);

    List<Site> findBySite(Site site);

    boolean addSite(Site site);
}
