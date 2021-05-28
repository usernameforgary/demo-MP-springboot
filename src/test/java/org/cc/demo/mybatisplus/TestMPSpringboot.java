package org.cc.demo.mybatisplus;

import lombok.extern.slf4j.Slf4j;
import org.cc.demo.mybatisplus.mapper.UserMapper;
import org.cc.demo.mybatisplus.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestMPSpringboot {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testGetAllUser() {
        List<User> users = userMapper.selectList(null);

        for(User user: users) {
            System.out.println(user.getUserName());
        }
    }
}

