package com.example.demo0116.service;

import com.example.demo0116.dao.UserMapper;
import com.example.demo0116.domain.User;
import com.example.demo0116.domain.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;
    public User findByUsername(String username){
        UserExample example = new UserExample();
        example.or().andUsernameEqualTo(username).andDeleteEqualTo(false);
        return userMapper.selectOneByExample(example);
    }

    public Object findById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> queryByUsername(String username){
        UserExample example = new UserExample();
        example.or().andUsernameEqualTo(username).andDeleteEqualTo(false);
        return userMapper.selectByExample(example);
    }

    public List<User> queryByMobile(String mobile){
        UserExample example = new UserExample();
        example.or().andMobileEqualTo(mobile).andDeleteEqualTo(false);
        return userMapper.selectByExample(example);
    }

    public List<User> queryByEmail(String email) {
        UserExample example = new UserExample();
        example.or().andEmailEqualTo(email).andDeleteEqualTo(false).andIdNotEqualTo(0);
        return userMapper.selectByExample(example);
    }

    public int updateById(User user) {
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public void add(User user){
        user.setAddTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insertSelective(user);
    }
}
