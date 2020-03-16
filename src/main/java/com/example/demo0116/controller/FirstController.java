package com.example.demo0116.controller;

import com.example.demo0116.domain.User;
import com.example.demo0116.service.UserService;
import com.example.demo0116.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo0116.util.ResponseCode.*;

@RestController
@RequestMapping("/user/auth")
public class FirstController {
    @Autowired
    UserService userService;

    @GetMapping("getUser")
    public Object getUser(String username){
        User userInfo = userService.findByUsername("姚培秀");
        return username;
    }

//    @PostMapping("login")
//    public Object login(@RequestBody String body, HttpServletRequest request){
//        String phone = JacksonUtil.parseString(body, "mobile");
//        String email = JacksonUtil.parseString(body, "email");
//        String password = JacksonUtil.parseString(body, "password");
//
//    }

    @PostMapping("register")
    public Object register(@RequestBody String body, HttpServletRequest request){
        String username = JacksonUtil.parseString(body, "username");
        String password = JacksonUtil.parseString(body, "password");
        String mobile = JacksonUtil.parseString(body, "mobile");
        String code = JacksonUtil.parseString(body, "code");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(mobile)
                || StringUtils.isEmpty(code)) {
            return ResponseUtil.badArgument();
        }

        List<User> userList = userService.queryByUsername(username);
        if (userList.size() > 0) {
            return ResponseUtil.fail(AUTH_NAME_REGISTERED, "用户名已注册");
        }

        userList = userService.queryByMobile(mobile);
        if (userList.size() > 0) {
            return ResponseUtil.fail(AUTH_MOBILE_REGISTERED, "手机号已注册");
        }
        if (!RegexUtil.isMobileExact(mobile)) {
            return ResponseUtil.fail(AUTH_INVALID_MOBILE, "手机号格式不正确");
        }

        //判断验证码是否正确
//        String cacheCode = CaptchaCodeManager.getCachedCaptcha(mobile);
//        if (cacheCode == null || cacheCode.isEmpty() || !cacheCode.equals(code)) {
//            return ResponseUtil.fail(AUTH_CAPTCHA_UNMATCH, "验证码错误");
//        }

        User user = null;
        System.out.println(password);
        String encodedPassword = MD5.encrypt32(password);
        user.setPassword(encodedPassword);
        user.setMobile(mobile);
        user.setUsername(username);
        userService.add(user);

        // token
        String token = UserTokenManager.generateToken(user.getId());

        Map<Object, Object> result = new HashMap<Object, Object>();
        result.put("token", token);
        result.put("userInfo", user);
        return ResponseUtil.ok(result);
    }
}
