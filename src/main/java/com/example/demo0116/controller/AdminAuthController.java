package com.example.demo0116.controller;

import com.example.demo0116.domain.Admin;
import com.example.demo0116.service.AdminService;
import com.example.demo0116.util.IpUtil;
import com.example.demo0116.util.JacksonUtil;
import com.example.demo0116.util.MD5;
import com.example.demo0116.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo0116.util.AdminResponseCode.ADMIN_INVALID_ACCOUNT;

@RestController
@RequestMapping("/admin/auth")
public class AdminAuthController {
    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    @CrossOrigin(maxAge = 3600)
    public Object login(@RequestBody String body, HttpServletRequest request){
        String username = JacksonUtil.parseString(body, "username");
        String password = JacksonUtil.parseString(body, "password");

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return ResponseUtil.badArgument();
        }
        Admin admin = adminService.findByUsername(username);
        if(admin == null){
            return ResponseUtil.fail(ADMIN_INVALID_ACCOUNT, "用户不存在");
        }
        if(!MD5.encrypt32(password).equals(admin.getPassword())){
            return ResponseUtil.fail(ADMIN_INVALID_ACCOUNT, "用户帐号或密码错误");
        }
        admin.setLastLoginIp(IpUtil.getIpAddr(request));
        admin.setLastLoginTime(LocalDateTime.now());

        adminService.updateById(admin);
        Map<Object, Object> result = new HashMap<Object, Object>();
        result.put("token", admin.getAdminId());
        return ResponseUtil.ok(result);
    }
    @GetMapping("/401")
    public Object page401() {
        return ResponseUtil.unlogin();
    }

    @GetMapping("/index")
    public Object pageIndex() {
        return ResponseUtil.ok();
    }

    @GetMapping("/403")
    public Object page403() {
        return ResponseUtil.unauthz();
    }

}
