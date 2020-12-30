package com.lz.controller;

import com.lz.entity.User;
import com.lz.frame.annotation.Result;
import com.lz.frame.common.Constants;
import com.lz.frame.common.R;
import com.lz.frame.util.RedisUtil;
import com.lz.service.IUserService;
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
 *                 1.使用 @Result 注解 进行二次封装 方法上可以返回原对象类型 如： public User add(User user) {}
 *                 2.也可以不使用注解封装 直接返回 R 对象类型 如: public R updUser(User user) {}
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
    private IUserService userService;

    @Result
    @ApiOperation("添加用户")
    @PostMapping("/add")
    public User add(User user) {
        userService.save(user);
        log.info("添加用户:{}", user);
        redisUtil.set(Constants.USER_PREFIX + user.getId(), user);
        log.info("将用户信息:{}写入Redis ...", user);
        return user;
    }

    @ApiOperation("获取用户信息")
    @Result
    @GetMapping("getUser")
    public Object getUser(Integer id) {
        //1.查询redis 有:直接返回 无:查询msyql
        Object obj = redisUtil.get(Constants.USER_PREFIX + id);
        if (obj != null) {
            log.info("查询Redis:{}", obj);
            return obj;
        }
        //2.查询mysql 有:存redis并返回 无:返回null
        User user = userService.getById(id);
        log.info("查询Mysql:{}", user);
        redisUtil.set(Constants.USER_PREFIX + id, user);
        log.info("将用户信息:{}写入Redis ...", user);
        return user;
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/updUser")
    public R updUser(User user) {
        userService.updateById(user);
        log.info("更新用户信息:mysql ...");
        redisUtil.set(Constants.USER_PREFIX + user.getId(), user);
        log.info("更新用户信息:redis ...");
        return R.success();
    }
}
