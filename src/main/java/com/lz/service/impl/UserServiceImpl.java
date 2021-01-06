package com.lz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.entity.User;
import com.lz.frame.ds.DS;
import com.lz.frame.ds.DSEnum;
import com.lz.mapper.UserMapper;
import com.lz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserMapper userMapper;

    @DS(DSEnum.ds2)
    @Override
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @DS(DSEnum.ds3)
    @Override
    public User getUserByName(String name) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("name",name));
    }
}
