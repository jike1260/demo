package com.lz.controller;

import com.alibaba.fastjson.JSON;
import com.lz.annotation.Result;
import com.lz.common.Constants;
import com.lz.entity.User;
import com.lz.service.UserService;
import com.lz.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description //TODO 用户相关
 * @Author lz
 * @Date 9:39 2020/12/29
 */
@Api(tags = "用户模块")
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * @Description TODO 获取用户信息
     * @Result 注解用于封装结果对象
     * @Param [id]
     * @Return com.lz.demo.entity.User
     * @Author lz
     * @Date 14:55 2020/12/29
     **/
    @ApiOperation("获取用户信息")
    @Result
    @GetMapping("/getUser")
    public User getUser(Integer id) {
        //1.查询缓存 有数据:直接返回 无数据:查询mysql
        Object obj = redisUtil.get(Constants.USER_PREFIX + id);
        if (obj != null) {
            User user = JSON.toJavaObject((JSON) obj, User.class);
            log.info("查询redis:{}", user);
            return user;
        }
        //2.查询mysql
        User user = userService.getUser(id);
        //int a = 1/0;
        //log.info(R.fail(ResultEnum.USER_ACCOUNT_FREEZE, user).toString());
        //return R.fail(ResultEnum.USER_ACCOUNT_FREEZE, user);
        log.info("查询mysql:{}", user.toString());
        //3.写入redis
        redisUtil.set(Constants.USER_PREFIX + id, user);
        return user;
    }
}
