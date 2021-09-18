package com.myteam.mall.mvc.interceptor;

import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.entity.Admin;
import com.myteam.mall.exception.AccessForbiddenException;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response,@NotNull Object handler) throws Exception {
        // 1.通过request对象获取Session对象
        HttpSession session = request.getSession();
        // 2.尝试从Session域获取Admin对象
        Admin admin = (Admin) session.getAttribute(MallConstant.ATTR_NAME_LOGIN_ADMIN);
        // 3.判断Admin对象是否为空
        if (admin == null) {
            // 4.抛出异常
            throw new AccessForbiddenException(MallConstant.MESSAGE_ACCESS_FORBIDDEN);
        }
        // 5. 若admin不为空，则返回true放行
        return true;
    }
}
