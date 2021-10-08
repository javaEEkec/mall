package com.myteam.mall.constant;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ljs
 * 前台工程中不需要登录检查的资源（需要放行的资源）
 */
public class AccessPassResources {
    public static final Set<String> PASS_RES_SET = new HashSet<>();

    static {
        PASS_RES_SET.add("/");
        PASS_RES_SET.add("/portal/user/to/reg/page");
        PASS_RES_SET.add("/portal/user/to/login/page");
        PASS_RES_SET.add("/do/user/register");
        PASS_RES_SET.add("/portal/user/do/login");
        PASS_RES_SET.add("/portal/user/logout");
        PASS_RES_SET.add("/get/portal/category/product/data");
        PASS_RES_SET.add("/product/to/page");
        PASS_RES_SET.add("/product/get/products/page/info");
        PASS_RES_SET.add("/product/get/online/product/detail/by/id");
    }

    public static final Set<String> STATIC_RES_SET = new HashSet<>();

    static {
        STATIC_RES_SET.add("bootstrap");
        STATIC_RES_SET.add("css");
        STATIC_RES_SET.add("fonts");
        STATIC_RES_SET.add("img");
        STATIC_RES_SET.add("jquery");
        STATIC_RES_SET.add("layer");
        STATIC_RES_SET.add("script");
        STATIC_RES_SET.add("ztree");
    }

    /**
     * 用于判断某个 ServletPath 值是否对应一个静态资源
     * @param servletPath
     * @return
     *      true：是静态资源
     *      false：不是静态资源
     */
    public static boolean judgeCurrentServletPathWhetherStaticResource(String servletPath) {

        if (servletPath == null || servletPath.length() == 0) {
            throw new RuntimeException(MallConstant.MESSAGE_STRING_INVALIDATE);
        }

        String[] split = servletPath.split("/");

        String firstLevelPath = split[1];

        return STATIC_RES_SET.contains(firstLevelPath);
    }
}
