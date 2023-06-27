package com.qf.j2112.service.impl;

import com.qf.j2112.mapper.CompanyMapper;
import com.qf.j2112.po.Company;
import com.qf.j2112.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
   @Resource
    CompanyMapper companyMapper;

    @Override
    public List<Company> findAll() {
        List<Company> all = companyMapper.findAll();
        return all;
    }

    @Override
    public boolean delCompany(Company company) {
        int i = companyMapper.delCompany(company);
        if (i>-1) return true;
        return false;
    }

    @Override
    public int addCompany(Company company) {
        int i = companyMapper.addCompany(company);
        return i;
    }

    @Override
    public Company findOneById(int id) {
        Company one = companyMapper.findOneById(id);
        return one;
    }

    @Override
    public Company findOneByname(String name) {
        Company byname = companyMapper.findOneByname(name);
        return byname;
    }
}
