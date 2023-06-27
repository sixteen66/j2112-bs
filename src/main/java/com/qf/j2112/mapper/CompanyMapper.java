package com.qf.j2112.mapper;

import com.qf.j2112.po.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMapper {
    List<Company> findAll();

    int delCompany(Company company);

    int addCompany(Company company);

    Company findOneById(@Param("id") int id);
    Company findOneByname(@Param("name") String  companyname);
}
