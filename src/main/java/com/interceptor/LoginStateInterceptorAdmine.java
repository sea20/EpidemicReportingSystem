package com.interceptor;

import com.bean.User;
import com.bean.result.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.result.R;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description :
 * @Author :Maple
 * @Create :2021-06-16 13:43
 */
@Component
public class LoginStateInterceptorAdmine implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        String json;
        ObjectMapper objectMapper = new ObjectMapper();
        User user;
        if (session == null || (user = (User) session.getAttribute("user")) == null){
            //未登录
            json = objectMapper.writeValueAsString(R.NotLogin());
        }else {
            Integer type = user.getType();
            //管理员
            if(type == 1){
                return true;
            }else {
                //不是管理员
                Result res = R.NotLogin();
                res.setMessage("您无管理员权限");
                json = objectMapper.writeValueAsString(res);
            }
        }
        response.setContentType("application/json;charset=utf-8");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(json.getBytes("utf-8"));
        return false;
    }
}
