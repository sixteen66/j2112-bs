package com.qf.j2112.Interceptor;

import com.qf.j2112.anno.JwtAnno;
import com.qf.j2112.util.JwtUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        boolean b=true;
        if (!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod method=(HandlerMethod)handler;
        JwtAnno anno = method.getMethodAnnotation(JwtAnno.class);
        if (anno!=null){
            String name = anno.name();
            if (token!=null && JwtUtils.checktoken(token)){
                b=true;
            }else b=false;
        }
        return b;
    }
}
