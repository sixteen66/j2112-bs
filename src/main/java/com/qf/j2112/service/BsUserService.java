package com.qf.j2112.service;

import com.qf.j2112.po.BsUser;
import com.qf.j2112.po.Role;
import com.qf.j2112.vo.LoginView;
import com.qf.j2112.vo.UpUserpass;
import com.qf.j2112.vo.UserInfo;
import com.qf.j2112.vo.UserRole;

import java.util.List;

public interface BsUserService {
    BsUser findOneByLoginName( String loginName);

    UserInfo findUserInfo(String loginName);

    UserRole findUserRole(String loginName);

    boolean updateUser(BsUser bsUser);

    boolean savePic(BsUser bsUser);

    boolean savePass(UpUserpass userpass);

    List<UserInfo> findAll();

    boolean delUser(int id);

    boolean delUserRole(int id);

    boolean upUserRole(Role role);

    BsUser addUser(BsUser bsUser);

    boolean addRole(Role role);

    BsUser findByReanlname(String name);

    BsUser findById(int id);

    List<UserInfo> findUserInfoByUser(BsUser bsUser);
}
