package com.xll.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author xulele
 * @Date: 2022/03/28/23:43
 * @Description:
 */
public class JWTUtils {

    private static final String secret = "@#723321@LX";

    private static final long expire = 1000L;

    /** 生成token header.payload.signature */
    public static String getToken(Map<String, Object> map) {
        String token = Jwts.builder().addClaims(map).setExpiration(DateUtil.addDate(new Date(), 1)).signWith(SignatureAlgorithm.HS256, secret).compact();
        return token;
    }

    /** 验证token */
    public static void verifyToken(String token) {
        Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
    }


    /** 获取token信息*/
    //private static Map getTokenInfo(String token) {
    //    Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    //    body.
    //}
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId",111);
        map.put("userName","许乐乐");
        System.out.println(getToken(map));

        verifyToken("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6IuiuuOS5kOS5kCIsInVzZXJJZCI6MTExLCJleHAiOjE2NDg1Njk1MTV9.YFzVoQEGlWQQpWsJ5IWfuP8NA-KRvnmgJgjQeGrFEL8");
    }
}
