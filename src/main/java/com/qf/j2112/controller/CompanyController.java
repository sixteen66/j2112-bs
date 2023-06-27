package com.qf.j2112.controller;

import com.qf.j2112.anno.JwtAnno;
import com.qf.j2112.po.Company;
import com.qf.j2112.service.CompanyService;
import com.qf.j2112.vo.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")

public class CompanyController {
    @Autowired
    CompanyService companyService;

    @RequestMapping("/company")
    public BaseResult findAll(){
        List<Company> all = companyService.findAll();

        BaseResult baseResult=new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setData(all);
        baseResult.setCode(200);
        return baseResult;
    }
@JwtAnno(name = "解约合作公司")
    @RequestMapping(value = "/delcompany",method = RequestMethod.POST)
    public BaseResult delComapny(@RequestBody Company company){
        boolean b = companyService.delCompany(company);
        BaseResult baseResult=new BaseResult();
        if (b){
            baseResult.setCode(200);
            baseResult.setData(null);
            baseResult.setMsg("ok");
        }else {
            baseResult.setCode(-200);
            baseResult.setMsg("no");
            baseResult.setData(null);
        }
        return baseResult;
    }
    @JwtAnno(name = "新增合作公司")
    @RequestMapping(value = "/addcompany",method = RequestMethod.POST)
    public BaseResult addCompany(@RequestBody Company company){
        int i = companyService.addCompany(company);
        BaseResult baseResult=new BaseResult();
        if (i>-1) {
            baseResult.setData(company);
            baseResult.setCode(200);
            baseResult.setMsg("ok");
        }
        return baseResult;
    }

    @RequestMapping(value = "/findOneByName",method = RequestMethod.POST)
    public BaseResult findOneByname(@RequestBody Company company){
        Company oneByname = companyService.findOneByname(company.getComname());
        BaseResult baseResult=new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setData(oneByname);
        baseResult.setCode(200);
        return baseResult;
    }
}
