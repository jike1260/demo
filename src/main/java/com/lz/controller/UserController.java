package com.lz.controller;

import com.lz.entity.User;
import com.lz.frame.annotation.Result;
import com.lz.frame.commons.Constant;
import com.lz.frame.commons.R;
import com.lz.frame.utils.RedisUtil;
import com.lz.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description //TODO 用户相关
 * @Author lz
 * @Date 10:54 2020/12/30
 */
@Slf4j
@Api(tags = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserService userService;

    @Result
    @ApiOperation("添加用户")
    @PostMapping("/add")
    public R add(User user) {
        userService.save(user);
        log.info("添加用户:{}", user);
        redisUtil.set(Constant.USER_PREFIX + user.getId(), user);
        log.info("将用户信息:{}写入Redis ...", user);
        return R.success(user);
    }

    @ApiOperation("获取用户信息")
    @Result
    @GetMapping("getUser")
    public R getUser(Integer id) {

        //1.查询redis 有:直接返回 无:查询msyql
        Object obj = redisUtil.get(Constant.USER_PREFIX + id);
        if (obj != null) {
            log.info("查询Redis:{}", obj);
            return R.success(obj);
        }
        //2.查询mysql 有:存redis并返回 无:返回null
        User user = userService.getById(id);
        log.info("查询Mysql:{}", user);
        //3.不为Null写入redis
        if(user != null){
            redisUtil.set(Constant.USER_PREFIX + id, user);
            log.info("将用户信息:{}写入Redis ...", user);
        }
        return R.success(user);
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/updUser")
    public R updUser(User user) {
        userService.updateById(user);
        log.info("更新用户信息:mysql ...");
        redisUtil.set(Constant.USER_PREFIX + user.getId(), user);
        log.info("更新用户信息:redis ...");
        return R.success(user);
    }
}
