package org.cc.demo.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.cc.demo.mybatisplus.pojo.User;

public interface UserMapper extends BaseMapper<User> {
    User findUserById(Long id);
}
