package com.qf.j2112.controller;


import com.qf.j2112.anno.JwtAnno;
import com.qf.j2112.po.Site;
import com.qf.j2112.service.SiteService;
import com.qf.j2112.vo.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SiteController {
    @Autowired
    SiteService siteService;

    @RequestMapping("/siteAll")
    public BaseResult findALL(){
        List<Site> all = siteService.findAll();
        BaseResult baseResult=new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setData(all);
        baseResult.setCode(200);
        return baseResult;
    }
    @JwtAnno(name = "修改站点信息")
    @RequestMapping(value = "/upSite",method = RequestMethod.POST)
    public BaseResult updateSite(@RequestBody Site site){
        boolean b = siteService.updateSite(site);
        BaseResult baseResult=new BaseResult();
        if (b){
            baseResult.setMsg("ok");
            baseResult.setData(site);
            baseResult.setCode(200);
        }else {
            baseResult.setMsg("ok");
            baseResult.setData(null);
            baseResult.setCode(200);
        }
        return baseResult;
    }
    @JwtAnno(name = "删除站点")
    @RequestMapping(value = "/delSite",method = RequestMethod.POST)
    public BaseResult delSite(@RequestBody Site site){
        boolean b = siteService.delSite(site);
        BaseResult baseResult=new BaseResult();
        if (b){
            baseResult.setMsg("ok");
            baseResult.setData(site);
            baseResult.setCode(200);
        }else {
            baseResult.setMsg("ok");
            baseResult.setData(null);
            baseResult.setCode(200);
        }
        return baseResult;
    }

    @RequestMapping(value = "/bySite",method = RequestMethod.POST)
    public BaseResult findBySite(@RequestBody Site site){
        List<Site> bySite = siteService.findBySite(site);
        BaseResult baseResult=new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setData(bySite);
        baseResult.setCode(200);
        return baseResult;
    }
    @JwtAnno(name = "新增站点")
    @RequestMapping(value = "/addSite",method = RequestMethod.POST)
    public BaseResult addSite(@RequestBody Site site){
        boolean b = siteService.addSite(site);
        BaseResult baseResult=new BaseResult();
        if (b){
            baseResult.setMsg("ok");
            baseResult.setData(site);
            baseResult.setCode(200);
        }else {
            baseResult.setMsg("ok");
            baseResult.setData(null);
            baseResult.setCode(200);
        }
        return baseResult;
    }
}
