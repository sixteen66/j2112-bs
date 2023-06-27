package com.qf.j2112.service.impl;

import com.qf.j2112.mapper.BsUserMapper;
import com.qf.j2112.po.BsUser;
import com.qf.j2112.po.Role;
import com.qf.j2112.service.BsUserService;
import com.qf.j2112.vo.LoginView;
import com.qf.j2112.vo.UpUserpass;
import com.qf.j2112.vo.UserInfo;
import com.qf.j2112.vo.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BsUserServiceImpl implements BsUserService {
    @Resource
    BsUserMapper bsUserMapper;

    @Override
    public BsUser findOneByLoginName(String loginName) {
        BsUser user = bsUserMapper.findOneByLoginName(loginName);
        return user;
    }

    @Override
    public UserInfo findUserInfo(String loginName) {
        UserInfo info = bsUserMapper.findUserInfo(loginName);
        return info;
    }

    @Override
    public UserRole findUserRole(String loginName) {
        UserRole userRole = bsUserMapper.findUserRole(loginName);
        return userRole;
    }

    @Override
    public boolean updateUser(BsUser bsUser) {
        int i = bsUserMapper.updateUser(bsUser);
        if (i>-1) return true;
        return false;
    }

    @Override
    public boolean savePic(BsUser bsUser) {
        int i = bsUserMapper.savepic(bsUser);
        if (i>-1) return true;
        return false;
    }

    @Override
    public boolean savePass(UpUserpass userpass) {
        int i = bsUserMapper.savepass(userpass);
        if (i>-1) return true;
        return false;
    }

    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> all = bsUserMapper.findAll();
        return all;
    }

    @Override
    public boolean delUser(int id) {
        int i = bsUserMapper.delUser(id);
        if (i>-1) return true;
        return false;
    }

    @Override
    public boolean delUserRole(int id) {
        int i = bsUserMapper.delUserRole(id);
        if (i>-1) return true;
        return false;
    }

    @Override
    public boolean upUserRole(Role role) {
        int i = bsUserMapper.upUserRole(role);
        if (i>-1) return true;
        return false;
    }

    @Override
    public BsUser addUser(BsUser bsUser) {
        int i = bsUserMapper.addUser(bsUser);
        if (i>-1) return bsUser;
        return null;
    }

    @Override
    public boolean addRole(Role role) {
        int i = bsUserMapper.addRole(role);
        if (i>-1) return true;
        return false;
    }

    @Override
    public BsUser findByReanlname(String name) {
        BsUser user = bsUserMapper.findByReanlname(name);
        return user;
    }

    @Override
    public BsUser findById(int id) {
        BsUser byId = bsUserMapper.findById(id);
        return byId;
    }

    @Override
    public List<UserInfo> findUserInfoByUser(BsUser bsUser) {
        List<UserInfo> user = bsUserMapper.findUserInfoByUser(bsUser);
        return user;
    }
}
