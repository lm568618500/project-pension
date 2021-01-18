package com.longjun.cto.framework.project.pension.intercepter;

import com.eims.cto.framework.common.core.utils.WebKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * CQC前端拦截器
 *
 * @author yangxuan
 * @date Sep 25, 2019 - 3:50:16 PM
 */
@Component
public class CqcWebIntercepter implements HandlerInterceptor {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WebKit webKit;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

       /* boolean ajaxFlag = false;
        if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
            ajaxFlag = true;
        }

        HttpSession httpSession = request.getSession();

        if (httpSession == null) {
            //没有值，没有登录，返回到登录页面：
            response.sendRedirect("/login");
            return false;
        }
//通过getAttribute获取session的值
        Object user = httpSession.getAttribute("cqc_user");
//判断是否有保存值，有即证明登录成功
        if (user != null) {
            //session不空，表示有保存值，有登陆，放行
            return true;
        } else {

            if(ajaxFlag){
                returnJson(response,"loginTimeout");
                return false;
            }
            //没有值，没有登录，返回到登录页面：
            response.sendRedirect("/login");
            return false;
        }*/
    return true;
//        return HandlerInterceptor.super.preHandle(request, response, handler);
    }


    private void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
            log.error("response error",e);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
