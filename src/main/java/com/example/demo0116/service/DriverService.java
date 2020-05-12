package com.example.demo0116.service;

import com.example.demo0116.dao.DriverMapper;
import com.example.demo0116.domain.Driver;
import com.example.demo0116.domain.DriverExample;
import com.example.demo0116.domain.OrdersExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DriverService {
    @Resource
    private DriverMapper driverMapper;

    public Driver findById(Integer id){
        return driverMapper.selectByPrimaryKey(id);
    }

    public List<Driver> findDriver(String realName, String mobile, String card, Integer page, Integer limit, String sort, String order){
        DriverExample example = new DriverExample();
        DriverExample.Criteria criteria = example.createCriteria();

        if (!realName.equals("null")){
            criteria.andRealnameLike("%" + realName +"%");
        }
        if(!mobile.equals("null")){
            criteria.andMobileEqualTo(mobile);
        }
        if(!card.equals("null")){
            criteria.andCardEqualTo(card);
        }
        criteria.andLogdeleteEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return driverMapper.selectByExample(example);
    }

    public int addDriver(Driver driver){
        driver.setAddTime(LocalDateTime.now());
        return driverMapper.insertSelective(driver);
    }

    public int updateDriver(Driver driver){
        driver.setUpdateTime(LocalDateTime.now());
        return driverMapper.updateByPrimaryKeySelective(driver);
    }
}
