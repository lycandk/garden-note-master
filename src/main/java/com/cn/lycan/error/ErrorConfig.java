//package com.cn.lycan.error;
//
//import org.springframework.boot.web.server.ErrorPage;
//import org.springframework.boot.web.server.ErrorPageRegistrar;
//import org.springframework.boot.web.server.ErrorPageRegistry;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//
///**
// * @author Makkapakka
// * @date 2022-5-16
// * @package_name com.cn.lycan.error
// * @description 此类用于将前后端整合部署时，要想办法触发前端路由，即在后端添加处理内容，把 通过这个 URL 渲染出的 index.html 返回到浏览器。
// * 实现 ErrorPageRegistrar 接口的类 ErrorConfig，把默认的错误页面设置为 /index.html
// */
//@Component
//public class ErrorConfig implements ErrorPageRegistrar {
//
//    @Override
//    public void registerErrorPages(ErrorPageRegistry registry) {
//        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
//        registry.addErrorPages(error404Page);
//    }
//}
