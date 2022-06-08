package com.example.store.service.impl;

import com.example.store.mapper.UserMapper;
import com.example.store.pojo.User;
import com.example.store.service.IUserService;
import com.example.store.service.ex.*;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {

        String username = user.getUsername();

        User result = userMapper.findByUsername(username);

        if(result != null) {
            throw new UsernameDuplicatedException("用户名被占用");
        }

        String oldPassword = user.getPassword();

        String salt = UUID.randomUUID().toString().toUpperCase();

        user.setSalt(salt);

        String md5Password = getMD5Password(oldPassword, salt);

        user.setPassword(md5Password);

        user.setIsDelete(0);

        user.setCreatedUser(user.getUsername());

        user.setModifiedUser(user.getUsername());

        Date date = new Date();

        user.setCreatedTime(date);

        user.setModifiedTime(date);

        Integer rows = userMapper.insert(user);

        if(rows != 1) {
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }

    }

    @Override
    public User login(String username, String password) {
        User result = userMapper.findByUsername(username);

        if(result == null) {
            throw new UserNotFoundException("用户数据不存在");
        }

        String oldPassword = result.getPassword();

        String salt = result.getSalt();

        String newMd5Password = getMD5Password(password, salt);

        if(!newMd5Password.equals(oldPassword)) {
            throw new PasswordNotMatchException("用户密码错误");
        }

//        if(result.getIsDelete() == 1) {
//            throw new UserNotFoundException("用户数据不存在");
//        }

        User user = new User();

        user.setUid(result.getUid());

        user.setUsername(result.getUsername());

        user.setAvatar(result.getAvatar());

        return user;

    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {

        User result = userMapper.findByUid(uid);

        if(result == null || result.getIsDelete() == 1) {

            throw new UserNotFoundException("用户数据不存在");

        }

        String oldMD5Password = getMD5Password(oldPassword, result.getSalt());

        if(!result.getPassword().equals(oldMD5Password)) {

            throw new PasswordNotMatchException("密码错误");

        }

        String newMD5Password = getMD5Password(newPassword, result.getSalt());

        Integer rows = userMapper.updatePasswordByUid(uid, newMD5Password, username, new Date());

        if (rows != 1) {
            throw new UpdateException("更新数据产生未知的异常");
        }

    }

    @Override
    public User getByUid(Integer uid) {

        User result = userMapper.findByUid(uid);

        if(result == null || result.getIsDelete() == 1) {

            throw new UserNotFoundException("用户数据不存在");

        }

        User user = new User();

        user.setUsername(result.getUsername());

        user.setPhone(result.getPhone());

        user.setEmail(result.getEmail());

        user.setGender(result.getGender());

        return user;
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {

        User result = userMapper.findByUid(uid);

        if(result == null) {

            throw new UserNotFoundException("用户数据不存在");

        }

        user.setUid(uid);

//        user.setUsername(username);

        user.setModifiedUser(username);

        user.setModifiedTime(new Date());

        Integer rows = userMapper.updateInfoByUid(user);

        System.out.println("rows: " + rows);

        if(rows != 1) {

            throw new UpdateException("更新数据时产生未知的异常");

        }

    }

    private String getMD5Password(String password, String salt) {

        for(int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }

        return password;

    }

}
