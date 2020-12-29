package com.lz.exception;

import com.lz.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GlobalExceptionHandler
 * @Description //TODO  全局异常处理 rest风格
 * @Author lz
 * @Date 11:12 2020/12/29
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @Description TODO 处理系统异常 自定义异常可直接返回 例:R.fail(StatusCode.USER_ACCOUNT_FREEZE)
     * @Param [request, e]
     * @Return com.lz.maike.controller.R
     * @Author lz
     * @Date 11:37 2020/12/29
     **/
    @ExceptionHandler(Exception.class)
    public R defaultErrorHandler(HttpServletRequest request, Exception e) {
        log.error("============================= 系统异常 =============================");
        log.error(R.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), request.getRequestURL()).toString());
        return R.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), request.getRequestURL());
    }
}
