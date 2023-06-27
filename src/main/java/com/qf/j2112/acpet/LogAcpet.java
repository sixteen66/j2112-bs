package com.qf.j2112.acpet;

import com.qf.j2112.anno.JwtAnno;
import com.qf.j2112.po.BsLog;
import com.qf.j2112.po.BsUser;
import com.qf.j2112.service.BsUserService;
import com.qf.j2112.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect

public class LogAcpet {

    @Autowired
    LogService logService;
    @Autowired
    BsUserService bsUserService;
    @Autowired
    HttpServletRequest request;
    @Resource
    Jedis jedis;

    @Pointcut("@annotation(com.qf.j2112.anno.JwtAnno)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String loginname = jedis.get("loginname");
        BsUser one = bsUserService.findOneByLoginName(loginname);
        int userid=2;
        if (!ObjectUtils.isEmpty(one)) {
            userid = one.getUserid();
        }

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        JwtAnno anno = method.getAnnotation(JwtAnno.class);
        BsLog Log = new BsLog();
        if (anno != null) {
            Log.setLogName(anno.name());
            Log.setLogTime(new Date());
            Log.setLogId(0);
            Log.setLogUserId(userid);
            Log.setUserIp(request.getRemoteAddr());
            logService.addLogg(Log);
        }
        Object proceed = joinPoint.proceed();
        return proceed;
    }
}
