package org.cc.demo.mybatisplus.mapper;

import org.cc.demo.mybatisplus.pojo.User;

public interface UserMapper extends MyBaseMapper<User> {
    User findUserById(Long id);
}
