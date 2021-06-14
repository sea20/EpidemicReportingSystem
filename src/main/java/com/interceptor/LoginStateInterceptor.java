package com.interceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.result.R;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @Auther: Maple
 * @Date: 2021/2/5
 */
@Component
//验证登录状态
public class LoginStateInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        //System.out.println(1);
        if(session != null && session.getAttribute("user") != null){
            return true;
        }
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        PrintWriter writer = response.getWriter();
        objectMapper.writeValue(writer,R.NotLogin());
        return false;
    }
}
