package com.example.store.service;

import com.example.store.mapper.UserMapper;
import com.example.store.pojo.User;
import com.example.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private IUserService userService;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("赵六");
            user.setPassword("123456");
            userService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login() {

        User user = userService.login("赵六", "123456");

        System.out.println(user);

    }

    @Test
    public void changePassword() {

        userService.changePassword(4, "赵六", "123456", "654321");

    }

    @Test
    public void getByUid() {

        System.out.println(userService.getByUid(4));

    }

    @Test
    public void changeInfo() {

        User user = new User();

        user.setPhone("110");

        user.setEmail("sxl18779314143@gmail.com");

        user.setGender(0);

        userService.changeInfo(4, "赵六", user);

    }

}
