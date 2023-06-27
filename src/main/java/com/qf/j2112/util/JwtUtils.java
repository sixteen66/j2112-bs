package com.qf.j2112.util;

import java.util.Date;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtils {
    public static final  String str="J2112";

    public static String gettoken(String username){
        /**
         * 生成签名，1小时后过期
         * @param userId
         * @return
         */
        long time=System.currentTimeMillis()+1*60*60*1000;
        Date date=new Date(time);
        JWTCreator.Builder builder = JWT.create();
        builder.withExpiresAt(date);
        builder.withClaim("username",username);
        Algorithm algorithm = Algorithm.HMAC256(str);
        String token = builder.sign(algorithm);
        return token;
    }
    /**
     * 校验token
     * @param token
     * @return
     */
    public static boolean checktoken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(str);
            JWTVerifier build = JWT.require(algorithm).build();
            DecodedJWT verify = build.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
