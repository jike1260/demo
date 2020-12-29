package com.lz.service.impl;

import com.lz.entity.User;
import com.lz.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UserServiceImpl
 * @Description //TODO 用户相关
 * @Author lz
 * @Date 14:20 2020/12/29
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    /**
     * @Description TODO 模拟数据据查询
     * @Param [id]
     * @Return com.lz.demo.entity.User
     * @Author lz
     * @Date 14:42 2020/12/29
     **/
    @Override
    public User getUser(Integer id) {
        User user = new User();
        user.setId(id);
        user.setAge(22);
        user.setName("用户_" + id);
        user.setPhone("13812341234");
        return user;
    }
}
