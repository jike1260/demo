package com.lz.frame.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.lz.frame.commons.Constant;
import com.lz.frame.commons.R;
import com.lz.frame.commons.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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

        //验证Token
        response.setCharacterEncoding("utf-8");
        String header = request.getHeader(Constant.AUTHORIZATION_HEADER);
        if (StringUtils.isBlank(header) && !header.startsWith(Constant.TOKEN_PREFIX)) {
            String token = header.substring(7);
            if (StringUtils.isNotBlank(token)) {
                // TODO 应与 redis中的token进行比较
                return true;
            }
        }
        //token验证失败 返回错误信息
        response.getWriter().write(JSONObject.toJSONString(R.fail(ResultEnum.TOKEN_FIAL)));
        return false;
    }
}
