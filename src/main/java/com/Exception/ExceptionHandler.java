package com.Exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.result.R;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: Maple
 * @Date: 2021/2/21
 */
public class ExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println("发生异常");
        System.out.println(e.getCause());
        HttpSession session = httpServletRequest.getSession(false);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PrintWriter writer = httpServletResponse.getWriter();
            objectMapper.writeValue(writer,R.Exception().add("data",e));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }
}
