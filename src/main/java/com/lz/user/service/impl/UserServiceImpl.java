package com.lz.user.service.impl;

import com.lz.user.entity.User;
import com.lz.user.mapper.UserMapper;
import com.lz.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lz
 * @since 2020-12-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
