package com.example.store.controller;

import com.example.store.pojo.User;
import com.example.store.service.IUserService;
import com.example.store.service.ex.InsertException;
import com.example.store.service.ex.UsernameDuplicatedException;
import com.example.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
//@Controller
@RequestMapping("users")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
//    @ResponseBody
    public JsonResult<Void> reg(User user) {

        JsonResult<Void> result = new JsonResult<>();

        return new JsonResult<>(OK);

//        try {
//            userService.reg(user);
//            result.setState(200);
//            result.setMessage("用户注册成功");
//        } catch (UsernameDuplicatedException e) {
//            result.setState(4000);
//            result.setMessage("用户名被占用");
//        } catch (InsertException e) {
//            result.setState(5000);
//            result.setMessage("注册时产生未知的异常");
//        }
//
//        return result;

    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession httpSession) {

        User data = userService.login(username, password);

        httpSession.setAttribute("uid", data.getUid());

        httpSession.setAttribute("username", data.getUsername());

        System.out.println(getUidFromSession(httpSession));

        System.out.println(getUsernameSession(httpSession));

        return new JsonResult<User>(OK, data);

    }

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession httpSession) {

        Integer uid = getUidFromSession(httpSession);

        String username = getUsernameSession(httpSession);

        userService.changePassword(uid, username, oldPassword, newPassword);

        return new JsonResult<>(OK);

    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession httpSession) {

        User data = userService.getByUid(getUidFromSession(httpSession));

        return new JsonResult<>(OK, data);

    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession httpSession) {

        Integer uid = getUidFromSession(httpSession);

        String username = getUsernameSession(httpSession);

        userService.changeInfo(uid, username, user);

        return new JsonResult<>(OK);

    }

}
