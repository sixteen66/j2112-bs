package com.qf.j2112.controller;

import com.qf.j2112.po.Notice;
import com.qf.j2112.service.NoticeService;
import com.qf.j2112.vo.BaseResult;
import com.qf.j2112.vo.Ypirce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @RequestMapping("/findNotice")
    public BaseResult findNotice(){
        Notice all = noticeService.findNotice();
        BaseResult baseResult=new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setData(all);
        baseResult.setCode(200);
        return baseResult;
    }

@RequestMapping(value = "/addNotice",method = RequestMethod.POST)
    public BaseResult addNOtice(@RequestBody Notice notice){
        int i = noticeService.updateNotice();
        BaseResult baseResult=new BaseResult();
        if (i>-1){
            notice.setNoTime(new Date());
            int i1 = noticeService.addNotice(notice);
            if (i1>-1){
                baseResult.setMsg("ok");
                baseResult.setData(notice);
                baseResult.setCode(200);
            }
        }else {
            baseResult.setMsg("ok");
            baseResult.setData(notice);
            baseResult.setCode(-200);
        }
        return baseResult;
    }

@RequestMapping(value = "/yprice",method = RequestMethod.POST)
    public BaseResult Price(@RequestBody Ypirce ypirce){
        int price=0;
        if (!ObjectUtils.isEmpty(ypirce.getAddId()) &&ypirce.getAddId()==2){
            price=ypirce.getKg()*2+4;
        }
        if (!ObjectUtils.isEmpty(ypirce.getAddId())&&ypirce.getAddId()==3){
            price=ypirce.getKg()*4+8;
        }
        BaseResult baseResult=new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setData(price);
        baseResult.setCode(200);
        return baseResult;
    }
}
