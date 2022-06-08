package com.example.store.controller;

import com.example.store.service.ex.*;
import com.example.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

public class BaseController {

    public static final int OK = 200;

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e) {

        JsonResult<Void> result = new JsonResult<>(e);

        if(e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("用户名已经被占用");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时产生未知的异常");
        } else if (e instanceof UserNotFoundException) {
            result.setState(5001);
            result.setMessage("用户数据不存在的异常");
        } else if (e instanceof InsertException) {
            result.setState(5002);
            result.setMessage("插入数据时产生未知的异常");
        } else if (e instanceof UpdateException) {
            result.setState(5003);
            result.setMessage("更新数据时产生未知的异常");
        }

        return result;

    }

    protected final Integer getUidFromSession(HttpSession session) {

        return Integer.valueOf(session.getAttribute("uid").toString());

    }

    protected final String getUsernameSession(HttpSession session) {

        return session.getAttribute("username").toString();

    }

}
