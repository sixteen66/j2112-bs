package com.qf.j2112.controller;

import com.qf.j2112.po.BsLog;
import com.qf.j2112.po.BsUser;
import com.qf.j2112.service.BsUserService;
import com.qf.j2112.service.LogService;
import com.qf.j2112.vo.BaseResult;
import com.qf.j2112.vo.LogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class LogController {
    @Autowired
    LogService logService;
    @Autowired
    BsUserService userService;

    @RequestMapping("/logAll")
    public BaseResult findAll(){
        List<BsLog> all = logService.findAll();
        BaseResult baseResult=new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setCode(200);
        baseResult.setData(all);
        return baseResult;
    }

    @RequestMapping(value = "/logByInfo",method = RequestMethod.POST)
    public BaseResult findByLog( @RequestBody LogInfo info){
        BsUser user = userService.findByReanlname(info.getRealname());
        if (!ObjectUtils.isEmpty(user)) {
            info.setUserId(user.getUserid());
        }
        List<BsLog> byInfo = logService.findLogByInfo(info);
        System.out.println(byInfo);
        for (BsLog log:byInfo) {
            BsUser byId = userService.findById(log.getLogUserId());
            if (!ObjectUtils.isEmpty(byId)){
            log.setRealname(byId.getRealname());
                System.out.println(log);}
        }
        BaseResult baseResult=new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setCode(200);
        baseResult.setData(byInfo);
        return baseResult;
    }
}
