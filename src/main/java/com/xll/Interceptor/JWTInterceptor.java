package com.xll.Interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xll.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author xulele
 * @Date: 2022/03/29/0:30
 * @Description:
 */
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map map = new HashMap();
        /** 获取请求头中的令牌 */
        String token = request.getHeader("Authorization");
        try {
            JWTUtils.verifyToken(token);
            return true;
        } catch (Exception e) {
           e.printStackTrace();
           map.put("msg","token认证失败");
        }
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json,charset=UTF-8");
        response.getWriter().print(json);
        return false;
    }
}
