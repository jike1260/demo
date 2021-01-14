package com.lz.service;

import com.lz.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lz
 * @since 2020-12-30
 */
public interface UserService extends IService<User> {

    User getUserByName(String name);

    List<User> getUserByAge(Integer age);

}
