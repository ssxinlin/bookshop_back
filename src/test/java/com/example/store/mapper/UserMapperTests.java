package com.example.store.mapper;

import com.example.store.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }

    @Test
    public void findByUsername() {
        User user = userMapper.findByUsername("张三");
        System.out.println(user);
    }

    @Test
    public void updatePasswordByUid() {

        userMapper.updatePasswordByUid(1, "321", "管理员", new Date());

    }

    @Test
    public void findByUid() {

        System.out.println(userMapper.findByUid(1));

    }

    @Test
    public void updateInfoByUid() {

        User user = new User();

        user.setUid(4);

        user.setPhone("18779314143");

        user.setEmail("2657078260@qq.com");

        user.setGender(1);

        userMapper.updateInfoByUid(user);

    }

}
