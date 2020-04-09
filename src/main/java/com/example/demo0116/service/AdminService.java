package com.example.demo0116.service;

import com.example.demo0116.dao.AdminMapper;
import com.example.demo0116.domain.Admin;
import com.example.demo0116.domain.AdminExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminService {
    @Resource
    private AdminMapper adminMapper;

    public List<Admin> findAdmin(String username, Integer type) {
        AdminExample example = new AdminExample();
        if (type == 0) {
            example.or().andUsernameEqualTo(username).andLogdeleteEqualTo(false);
        } else {
            example.or().andUsernameEqualTo(username).andLogdeleteEqualTo(false);
        }
        return adminMapper.selectByExample(example);
    }

    public Admin findAdmin(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    public int updateById(Admin admin) {
        admin.setUpdateTime(LocalDateTime.now());
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    public Integer delete(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    public Integer add(Admin admin) {
        admin.setAddTime(LocalDateTime.now());
        admin.setUpdateTime(LocalDateTime.now());
        return adminMapper.insertSelective(admin);
    }

    public Admin findById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    public List<Admin> all() {
        AdminExample example = new AdminExample();
        example.or().andLogdeleteEqualTo(false);
        return adminMapper.selectByExample(example);
    }
}
