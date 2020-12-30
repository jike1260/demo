package com.lz.frame.advice;

import com.lz.frame.annotation.Result;
import com.lz.frame.common.Constants;
import com.lz.frame.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ResResultHandler
 * @Description //TODO 重写返回体
 * @Author lz
 * @Date 10:32 2020/12/29
 */
@Slf4j
@ControllerAdvice
public class ResultHandler implements ResponseBodyAdvice<Object> {

    /**
     * @Description TODO 判断请求是否包含了 @Result 注解，有：重写返回体 没有：直接返回
     * @Param [methodParameter, aClass]
     * @Return boolean
     * @Author lz
     * @Date 10:34 2020/12/29
     **/
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        //判断请求 是否有封装标记
        Result result = (Result) request.getAttribute(Constants.RESPONSE_RESULT_ANN);
        return result == null ? false : true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.info("返回体{} 重写格式 处理中 ...", o);
        return R.success(o);
    }
}
