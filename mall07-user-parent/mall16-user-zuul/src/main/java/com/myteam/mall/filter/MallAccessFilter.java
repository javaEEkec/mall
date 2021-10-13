package com.myteam.mall.filter;

import com.myteam.mall.constant.AccessPassResources;
import com.myteam.mall.constant.MallConstant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * filterType：返回过滤器的类型。有pre、route、post、error等几种取值，分别对应几种过滤器。
 * filterOrder：返回一个int值来指定过滤器的执行顺序，不同的过滤器允许返回相同的数字。
 * shouldFilter：返回一个boolean值来判断该过滤器是否要执行，true表示执行，false表示不执行。
 * run：过滤器的具体逻辑。本例中，我们让它打印了请求的HTTP方法以及请求的地址
 * @author mzx
 */
@Component
public class MallAccessFilter extends ZuulFilter {


    /**
     * to classify a filter by type. Standard types in Zuul are "pre" for pre-routing filtering,
     * "route" for routing to an origin, "post" for post-routing filters, "error" for error handling.
     * We also support a "static" type for static responses see  StaticResponseFilter.
     * Any filterType made be created or added and run by calling FilterProcessor.runFilters(type)
     *
     * @return A String representing that type
     */
    @Override
    public String filterType() {
        // 目标微服务前执行前过滤
        return "pre";
    }

    /**
     * filterOrder() must also be defined for a filter. Filters may have the same  filterOrder if precedence is not
     * important for a filter. filterOrders do not need to be sequential.
     *
     * @return the int order of a filter
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * a "true" return from this method means that the run() method should be invoked
     *
     * @return true if the run() method should be invoked. false will not invoke the run() method
     */
    @Override
    public boolean shouldFilter() {
        // 1.获取RequestContext对象
        RequestContext requestContext = RequestContext.getCurrentContext();

        // 2.通过RequestContext对象获取当前请求对象（ 框架底层是借助 ThreadLocal 从当前线程上获取事先绑定的 Request 对象）
        HttpServletRequest request = requestContext.getRequest();

        // 3.获取 servletPath 值
        String servletPath = request.getServletPath();

        // 4.根据 servletPath 判断当前请求是否对应可以直接放行的特定功能
        boolean containsResult = AccessPassResources.PASS_RES_SET.contains(servletPath);
        // 如果当前请求是可以直接放行的特定功能请求则返回 false 放行
        if (containsResult){
            return false;
        }

        // 5.判断当前请求是否为静态资源,不是静态资源则执行run方法做登录检查
        return !AccessPassResources.judgeCurrentServletPathWhetherStaticResource(servletPath);
    }

    /**
     * if shouldFilter() is true, this method will be invoked. this method is the core method of a ZuulFilter
     *
     * @return Some arbitrary artifact may be returned. Current implementation ignores it.
     * @throws ZuulException if an error occurs during execution.
     */
    @Override
    public Object run() throws ZuulException {
        // 1.获取当前请求对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        // 2.获取当前Session对象
        HttpSession session = request.getSession();

        // 3.尝试从 Session 对象中获取已登录用户
        Object loginUser = session.getAttribute(MallConstant.ATTR_NAME_LOGIN_USER);
        Object loginShop = session.getAttribute(MallConstant.ATTR_NAME_LOGIN_SHOP);
        System.out.println("loginUser="+loginUser);
        System.out.println("loginShop="+loginShop);
        // 4.判断 loginUser 是否为空
        if (loginUser == null && loginShop == null){
            // 5.从requestContext对象中获取Response对象
            HttpServletResponse response = requestContext.getResponse();
            // 6.将提示消息存入session域
            session.setAttribute(MallConstant.ATTR_NAME_MESSAGE,MallConstant.MESSAGE_ACCESS_FORBIDDEN);
            // 7.重定向到 portal-consumer 工程中的登录页面
            try {
                response.sendRedirect("/portal/user/to/login/page");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
