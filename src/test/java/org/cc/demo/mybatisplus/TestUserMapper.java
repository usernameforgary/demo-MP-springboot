package org.cc.demo.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cc.demo.mybatisplus.mapper.UserMapper;
import org.cc.demo.mybatisplus.pojo.User;
import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserMapper {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setMail("caocao@com");
        user.setAge(30);
        user.setName("曹操");
        user.setUserName("caocao");
        user.setPassword("123456");

        int result = userMapper.insert(user);
        System.out.println("result => " + result);

        System.out.println("new id => " + user.getId());
    }

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1l);
        System.out.println(user.getUserName() + ": user password " + user.getPassword());
    }

    @Test
    public void testUpdateById() {
       User user = new User();
       user.setId(1L);
       user.setAge(19);
       user.setPassword("6666");

       userMapper.updateById(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setAge(20);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", "zhangsan");

        userMapper.update(user, queryWrapper);
    }

    @Test
    public void deleteBatchIds() {
       this.userMapper.deleteBatchIds(Arrays.asList(1,2));
    }

    @Test
    public void testSelectPage() {
        Page<User> page = new Page<>(1,1);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email", "@");
        IPage<User> pageUsers = this.userMapper.selectPage(page, wrapper);

        for(User user : pageUsers.getRecords()) {
            System.out.println(user.getUserName());
        }
    }

    @Test
    public void testSelectUserById() {
        User user = userMapper.selectById(1L);
        System.out.println(user.getUserName());
    }
}
