package com.qf.j2112.mapper;

import com.qf.j2112.po.BsUser;
import com.qf.j2112.po.Role;
import com.qf.j2112.vo.LoginView;
import com.qf.j2112.vo.UpUserpass;
import com.qf.j2112.vo.UserInfo;
import com.qf.j2112.vo.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BsUserMapper {

    BsUser findOneByLoginName(@Param("name") String loginName);

    UserInfo findUserInfo(@Param("name") String loginName);

    UserRole findUserRole(@Param("name") String loginName);

    int updateUser(BsUser bsUser);

    int savepic(BsUser bsUser);

    int savepass(UpUserpass userpass);

    List<UserInfo> findAll();

    int delUser(@Param("id") int id);

    int delUserRole(@Param("id") int id);

    int upUserRole(Role role);

    int addUser(BsUser bsUser);

    int addRole(Role role);

    BsUser findByReanlname(@Param("name") String name);

    BsUser findById(@Param("id") int  id);

    List<UserInfo> findUserInfoByUser(BsUser bsUser);
}
