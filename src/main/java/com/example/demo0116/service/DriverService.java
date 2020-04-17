package com.example.demo0116.service;

import com.example.demo0116.dao.DriverMapper;
import com.example.demo0116.domain.Driver;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DriverService {
    @Resource
    private DriverMapper driverMapper;

    public Driver findById(Integer id){
        return driverMapper.selectByPrimaryKey(id);
    }
}
