package com.qf.j2112.service.impl;

import com.qf.j2112.mapper.SiteMapper;
import com.qf.j2112.po.Site;
import com.qf.j2112.service.SiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {
    @Resource
    SiteMapper siteMapper;
    @Override
    public List<Site> findAll() {
        List<Site> all = siteMapper.findAll();
        return all;
    }

    @Override
    public boolean updateSite(Site site) {
        int i = siteMapper.updateSite(site);
        if (i>-1) return true;
        return false;
    }

    @Override
    public boolean delSite(Site site) {
        int i = siteMapper.delSite(site);
        if (i>-1) return true;
        return false;
    }

    @Override
    public List<Site> findBySite(Site site) {
        List<Site> bySite = siteMapper.findBySite(site);
        return bySite;
    }

    @Override
    public boolean addSite(Site site) {
        int i = siteMapper.addSite(site);
        if (i>-1) return true;
        return false;
    }
}
