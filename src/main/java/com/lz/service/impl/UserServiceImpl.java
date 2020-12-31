package com.lz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.entity.User;
import com.lz.mapper.UserMapper;
import com.lz.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lz
 * @since 2020-12-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
