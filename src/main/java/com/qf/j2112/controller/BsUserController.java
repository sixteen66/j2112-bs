package com.qf.j2112.controller;


import com.qf.j2112.anno.JwtAnno;
import com.qf.j2112.po.BsUser;
import com.qf.j2112.po.Role;
import com.qf.j2112.service.BsUserService;
import com.qf.j2112.util.JwtUtils;
import com.qf.j2112.util.QnyUtil;
import com.qf.j2112.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api")
@Slf4j
@Component
public class BsUserController {
    @Autowired      //通过by byte自动注入
    BsUserService service;
    @Resource       //默认通过byName自动注入
    Jedis jedis;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResult login(@RequestBody LoginView loginView){
        jedis.set("loginname",loginView.getUsername());
        BsUser user = service.findOneByLoginName(loginView.getUsername());
        BaseResult result=new BaseResult();
        if (!ObjectUtils.isEmpty(user)&&loginView.getPassword().equals(user.getPassword())){
            String token = JwtUtils.gettoken(user.getLoginname());
            log.info("token=="+token);
            loginView.setPassword(null);
            result.setCode(200);
            result.setMsg("ok");
            result.setData(token);
        }else {
            result.setCode(-200);
            result.setData(null);
            result.setMsg("no");
        }
        return result;
    }

    @RequestMapping(value = "/userInfo",method = RequestMethod.POST)
    public BaseResult userInfo( @RequestBody LoginView loginView){
        UserInfo info = service.findUserInfo(loginView.getUsername());
        log.info(loginView.getUsername());
        BaseResult result=new BaseResult();
        if (!ObjectUtils.isEmpty(info)){
            result.setCode(200);
            result.setMsg("ok");
            result.setData(info);
        }else {
            result.setCode(-200);
            result.setData(null);
            result.setMsg("no");
        }
        return result;
    }

    @RequestMapping("/upload")
    public BaseResult  uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        BaseResult result = new BaseResult();
        result.setCode(200);
//        上传文件
        InputStream is = file.getInputStream();
        if (is!=null){
            String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String s = UUID.randomUUID().toString();
            String fileName =s.replace("-","")+fileType;
            String url = QnyUtil.updateFile(file,fileName);
            result.setData(url);
            log.info(url);
        }
        return result;
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public BaseResult updateUser(@RequestBody BsUser bsUser){
        boolean b = service.updateUser(bsUser);
        BaseResult result = new BaseResult();
        if (b){
            UserInfo info = service.findUserInfo(bsUser.getLoginname());
            result.setCode(200);
            result.setMsg("ok");
            result.setData(info);
        }else {
            result.setCode(-200);
            result.setMsg("no");
            result.setData(null);
        }

        return result;
    }
    @RequestMapping(value = "/savepic",method = RequestMethod.POST)
    public BaseResult savepic(@RequestBody BsUser bsUser){
        boolean b = service.savePic(bsUser);
        BaseResult result = new BaseResult();
        if (b){
            result.setCode(200);
            result.setMsg("ok");
            result.setData(null);
        }else {
            result.setCode(-200);
            result.setMsg("no");
            result.setData(null);
        }
        return result;
    }

    @RequestMapping(value = "/savepwd",method = RequestMethod.POST)
    public BaseResult savePass(@RequestBody UpUserpass userpass){
        BaseResult result=new BaseResult();
        BsUser user = service.findOneByLoginName(userpass.getLoginname());
        if (!ObjectUtils.isEmpty(user)&&user.getPassword().equals(userpass.getPwd())){
            boolean b = service.savePass(userpass);
                result.setCode(200);
                result.setMsg("update ok");
                result.setData(null);
        }else {
            result.setCode(-200);
            result.setMsg("原密码不正确！");
            result.setData(null);
        }
        return result;
    }
    @RequestMapping("/findAll")
    public BaseResult findAll(){
        List<UserInfo> all = service.findAll();
        BaseResult result = new BaseResult();
            result.setCode(200);
            result.setMsg("ok");
            result.setData(all);
            return result;
    }
    @JwtAnno(name = "开除员工")
    @RequestMapping(value = "/delUser",method = RequestMethod.POST)
    public BaseResult delUser(@RequestBody BsUser bsUser){
        boolean b = service.delUser(bsUser.getUserid());
        boolean b1 = service.delUserRole(bsUser.getUserid());
        BaseResult result = new BaseResult();
        if (b){
                result.setCode(200);
                result.setMsg("ok");
                result.setData(null);
        }else {
            result.setCode(-200);
            result.setMsg("no");
            result.setData(null);
        }

        return result;
    }

    @JwtAnno(name = "修改员工权限")
    @RequestMapping(value = "/upUserRole",method = RequestMethod.POST)
    public BaseResult upUserRole(@RequestBody Role role){
        boolean b = service.upUserRole(role);
        BaseResult result = new BaseResult();
        if (b){
            result.setCode(200);
            result.setMsg("ok");
            result.setData(null);
        }else {
            result.setCode(-200);
            result.setMsg("no");
            result.setData(null);
        }

        return result;
    }
    @JwtAnno(name = "添加新员工信息")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public BaseResult addUser(@RequestBody BsUser user){
        user.setPassword("1234");
        BsUser bsUser = service.addUser(user);
        BaseResult result = new BaseResult();
        result.setCode(200);
        result.setMsg("ok");
        result.setData(bsUser);
        return result;
    }

    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public BaseResult addRole(@RequestBody Role role){
        boolean b = service.addRole(role);
        BaseResult result = new BaseResult();
        if (b){
            result.setCode(200);
            result.setMsg("ok");
            result.setData(null);
        }else {
            result.setCode(-200);
            result.setMsg("no");
            result.setData(null);
        }

        return result;
    }

    @RequestMapping(value = "/userRole",method = RequestMethod.POST)
    public BaseResult UserRole(@RequestBody LoginView loginView){
        UserRole userRole = service.findUserRole(loginView.getUsername());
        BaseResult result = new BaseResult();
        if (!ObjectUtils.isEmpty(userRole)&&userRole.getRoleid()<3){
            result.setCode(200);
            result.setMsg("ok");
            result.setData(null);
        }
        if (!ObjectUtils.isEmpty(userRole)&&userRole.getRoleid()==3){

            result.setCode(-200);
            result.setMsg("ok");
            result.setData(null);
        }
        return result;
    }
}
