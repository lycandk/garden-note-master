//package com.cn.lycan.interceptor;
//
//import com.cn.lycan.entity.User;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.apache.commons.lang.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * @author Makkapakka
// * @date 2022-5-16
// * @package_name com.cn.lycan.interceptor
// * @description 后端拦截器:如果没有把前后端项目整合起来，就没有办法使用这种方式
// *  * 拦截器的逻辑如下：
// *  * 1.用户访问 URL，检测是否为登录页面，如果是登录页面则不拦截
// *  * 2.如果用户访问的不是登录页面，检测用户是否已登录，如果未登录则跳转到登录页面
// *  * 为了保存登录状态，我们可以把用户信息存在 Session 对象中（当用户在应用程序的 Web 页之间跳转时，存储在 Session 对象中的变量不会丢失），
// *  * 这样在访问别的页面时，可以通过判断是否存在用户变量来判断用户是否登录。
// *  在 Springboot 我们可以直接继承拦截器的接口，然后实现 preHandle 方法。preHandle 方法里的代码会在访问需要拦截的页面时执行
// */
//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception{
//        HttpSession httpSession = httpServletRequest.getSession();
//        String contextPath = httpSession.getServletContext().getContextPath();
//        String[] requireAuthPages = new String[]{
//                "index",
//        };
//
//        String uri = httpServletRequest.getRequestURI();
//
//        uri = StringUtils.remove(uri, contextPath+"/");
//        String page = uri;
//
//        if(begingWith(page, requireAuthPages)){
//            User user = (User) httpSession.getAttribute("user");
//            if(user==null) {
//                httpServletResponse.sendRedirect("login");
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean begingWith(String page, String[] requiredAuthPages) {
//        boolean result = false;
//        for (String requiredAuthPage : requiredAuthPages) {
//            if(StringUtils.startsWith(page, requiredAuthPage)) {
//                result = true;
//                break;
//            }
//        }
//        return result;
//    }
//
//}
