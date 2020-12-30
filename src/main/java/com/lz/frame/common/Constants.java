package com.lz.frame.common;

/**
 * @ClassName Constants
 * @Description //TODO 常量
 * @Author lz
 * @Date
 */
public interface Constants {

    /** 请求头Key */
    String AUTHORIZATION_HEADER = "Authorization";

    /** Token前缀 */
    String TOKEN_PREFIX = "Bearer ";

    /** 注解@Result标记 */
    String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";

    /** Redis 用户数据前缀 */
    String USER_PREFIX = "user:info:";

}
