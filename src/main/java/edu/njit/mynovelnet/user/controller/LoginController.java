package edu.njit.mynovelnet.user.controller;

import com.alibaba.fastjson.JSON;
import edu.njit.mynovelnet.myutil.DataUtil;
import edu.njit.mynovelnet.myutil.Message;
import edu.njit.mynovelnet.user.entity.ReaderEntity;
import edu.njit.mynovelnet.user.entity.User;
import edu.njit.mynovelnet.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/comfirm", produces = "application/json")
    @ResponseBody
    public String comfirm(HttpServletRequest request, HttpServletResponse response, String userId, String password) throws IOException {
        Message message;
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        User user = userService.getUserInfoById(userId);
        if (userId != null && userId.equals(user.getUserId())) {
            if (password != null && password.equals(user.getPassword())) {
                ReaderEntity readerEntity = userService.getReaderInfoById(userId);
                // 创建cookie并将成功登陆的用户保存在里面
                Cookie cookie = new Cookie("userId", userId);
                Cookie cookie1 = new Cookie("password", password);
                Cookie cookie2 = new Cookie("identity", user.getIdentity().toString());
                Cookie cookie3 = new Cookie("userUuid", readerEntity.getUserUuid());
                Cookie cookie4 = new Cookie("username", readerEntity.getUsername());
                cookie.setMaxAge(60 * 60 * 24);
                cookie1.setMaxAge(60 * 60 * 24);
                cookie2.setMaxAge(60 * 60 * 24);
                cookie3.setMaxAge(60 * 60 * 24);
                cookie4.setMaxAge(60 * 60 * 24);
                cookie.setPath("/");
                cookie1.setPath("/");
                cookie2.setPath("/");
                cookie3.setPath("/");
                cookie4.setPath("/");
                // 服务器返回给浏览器cookie以便下次判断
                response.addCookie(cookie);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
                response.addCookie(cookie3);
                response.addCookie(cookie4);
                message = Message.setMessage(1, readerEntity.getUsername());
            } else {
                message = Message.setMessage(2, null);
            }
        } else {
            message = Message.setMessage(3, null);
        }
        return JSON.toJSONString(message);
    }

    @RequestMapping(value = "/autoLogin", produces = "application/json")
    @ResponseBody
    public String autoLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Message message;
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userId = "";
        String password = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                userId = cookie.getValue();
            } else if (cookie.getName().equals("password")) {
                password = cookie.getValue();
            }
        }
        User user = userService.getUserInfoById(userId);
        if (userId != null && userId.equals(user.getUserId())) {
            if (password != null && password.equals(user.getPassword())) {
                ReaderEntity readerEntity = userService.getReaderInfoById(userId);
                session.setAttribute("userUuid", readerEntity.getUserUuid());
                session.setAttribute("username", readerEntity.getUsername());
                message = Message.setMessage(1, readerEntity.getUsername());
            } else {
                message = Message.setMessage(2, "密码或已修改");
            }
        } else {
            message = Message.setMessage(3, "没有登陆信息");
        }
        return JSON.toJSONString(message);
    }


    @RequestMapping(value = "/register", produces = "application/json")
    @ResponseBody
    public String register(HttpServletRequest request, HttpServletResponse response, String userId, String username, String password, Character sex) throws IOException {
        Message message;
        if (userService.ifExistAlreadyByUserId(userId)) {
            return JSON.toJSONString(Message.setMessage(2, "账号已注册"));
        } else if (userService.ifExistAlreadyByUsername(username)) {
            return JSON.toJSONString(Message.setMessage(2, "用户名已存在"));
        }
        String uuid = DataUtil.getUUID();
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        user.setIdentity('1');
        ReaderEntity readerEntity = new ReaderEntity();
        readerEntity.setUserId(userId);
        readerEntity.setUserUuid(uuid);
        readerEntity.setUsername(username);
        readerEntity.setGender(sex);
        userService.insertRegistesUser(user);
        userService.insertRegistreReader(readerEntity);
        message = Message.setMessage(1, "注册成功");
        return JSON.toJSONString(message);
    }

}
