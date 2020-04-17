package com.example.demo0116.controller;

import com.example.demo0116.domain.Admin;
import com.example.demo0116.service.AdminService;
import com.example.demo0116.util.MD5;
import com.example.demo0116.util.RegexUtil;
import com.example.demo0116.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.demo0116.util.AdminResponseCode.*;

@RestController
@RequestMapping("/admin/admin")
public class AdminAdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public Object create(@RequestBody Admin admin) {
        Object error = validate(admin);
        if (error != null) {
            return error;
        }

        String username = admin.getUsername();
        List<Admin> adminList = adminService.findAdmin(username, 0);
        if (adminList.size() > 0) {
            return ResponseUtil.fail(ADMIN_NAME_EXIST, "管理员已经存在");
        }

        String rawPassword = admin.getPassword();
        String encodedPassword = MD5.encrypt32(rawPassword);
        admin.setPassword(encodedPassword);
        adminService.add(admin);
        return ResponseUtil.ok(admin);
    }

    private Object validate(Admin admin) {
        String name = admin.getUsername();
        if (StringUtils.isEmpty(name)) {
            return ResponseUtil.badArgument();
        }
        if (!RegexUtil.isUsername(name)) {
            return ResponseUtil.fail(ADMIN_INVALID_NAME, "管理员名称不符合规定");
        }
        String password = admin.getPassword();
        if (StringUtils.isEmpty(password) || password.length() < 6) {
            return ResponseUtil.fail(ADMIN_INVALID_PASSWORD, "管理员密码长度不能小于6");
        }
        return null;
    }

    /**
     * 管理员删除
     * @param adminId
     * @return
     */
    @PostMapping("deleteAdmin")
    public int deleteAdmin(Integer adminId){
        Admin admin = adminService.findById(adminId);
        admin.setLogdelete(true);
        return adminService.updateById(admin);
    }

    @PostMapping("updateAdmin")
    public Object updateAdmin(@RequestBody Admin admin){
        if(adminService.updateById(admin) == 0){
            return ResponseUtil.fail(ADMIN_ALTER_NOT_ALLOWED, "数据更新失败");
        }else {
            return ResponseUtil.ok();
        }
    }
}
