package com.example.demo0116.service;

import com.example.demo0116.dao.CarsMapper;
import com.example.demo0116.domain.Cars;
import com.example.demo0116.domain.CarsExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

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

    public List<Cars> getOnCars(){
        CarsExample example = new CarsExample();
        example.or().andStatusEqualTo(0).andLogdeleteEqualTo(false);
        return carsMapper.selectByExample(example);
    }

    public List<Cars> getCars(String model, Integer driverId, String license, Integer page, Integer limit){
        CarsExample example = new CarsExample();
        CarsExample.Criteria criteria = example.createCriteria();

        if (!model.equals("null")){
            criteria.andModelLike("%" + model +"%");
        }
        if(!driverId.equals(0)){
            criteria.andDriverIdEqualTo(driverId);
        }
        if(!license.equals("null")){
            criteria.andLicenseNumberEqualTo(license);
        }
        criteria.andLogdeleteEqualTo(false);

        PageHelper.startPage(page, limit);
        return carsMapper.selectByExample(example);
    }

    public int updateCar(Cars car){
        return carsMapper.updateByPrimaryKeySelective(car);
    }

    public int addCar(Cars car){
        return carsMapper.insertSelective(car);
    }
}
