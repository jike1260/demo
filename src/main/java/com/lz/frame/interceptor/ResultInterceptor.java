package com.lz.frame.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName ResResultInterceptor
 * @Description //TODO 拦截器 判断此请求的返回结果是否需要封装
 * @Author lz
 * @Date 10:14 2020/12/29
 */
@Slf4j
@Component
public class ResultInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.为有 @Result 注解的请求设置标记 【暂时不启用 直接用R对象封装返回体 同时关闭 ResultHandler】
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Class<?> beanType = handlerMethod.getBeanType();
//            Method method = handlerMethod.getMethod();
//            //类上有 @Result 注解
//            if (beanType.isAnnotationPresent(Result.class)) {
//                //设置此请求返回体，需要封装，向下传递，在ResponseBodyAdvice接口进行判断
//                request.setAttribute(Constant.RESPONSE_RESULT_ANN, beanType.getAnnotation(Result.class));
//                //方法上有 @Result 注解
//            } else if (method.isAnnotationPresent(Result.class)) {
//                request.setAttribute(Constant.RESPONSE_RESULT_ANN, method.getAnnotation(Result.class));
//            }
//        }
        return true;
        //2.验证Token
//        response.setCharacterEncoding("utf-8");
//        String header = request.getHeader(Constants.AUTHORIZATION_HEADER);
//        if (StringUtils.isBlank(header) && !header.startsWith(Constants.TOKEN_PREFIX)) {
//            String token = header.substring(7);
//            if (StringUtils.isNotBlank(token)) {
//                return true;
//            }
//        }
//        //token验证失败 返回错误信息
//        response.getWriter().write(JSONObject.toJSONString(R.fail(ResultEnum.TOKEN_FIAL)));
//        return false;
    }
}
