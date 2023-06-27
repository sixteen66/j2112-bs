package com.qf.j2112.service;

import com.qf.j2112.po.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    boolean delCompany(Company company);

    int addCompany(Company company);

    Company findOneById(int id);

    Company findOneByname(String name);
}
