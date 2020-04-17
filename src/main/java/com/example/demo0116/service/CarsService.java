package com.example.demo0116.service;

import com.example.demo0116.dao.CarsMapper;
import com.example.demo0116.domain.Cars;
import com.example.demo0116.domain.CarsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CarsService {
    @Resource
    private CarsMapper carsMapper;

    public Cars findById(Integer id){
        return carsMapper.selectByPrimaryKey(id);
    }

    public Cars findByDriverId(Integer driverId){
        CarsExample example = new CarsExample();
        example.or().andDriverIdEqualTo(driverId);
        return carsMapper.selectOneByExample(example);
    }
}
