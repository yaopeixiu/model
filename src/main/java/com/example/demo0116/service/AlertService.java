package com.example.demo0116.service;

import com.example.demo0116.dao.AbnormalMapper;
import com.example.demo0116.domain.Abnormal;
import com.example.demo0116.domain.AbnormalExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AlertService {
    @Resource
    private AbnormalMapper abnormalMapper;

    public List<Abnormal> findalerts(Integer status, Integer orderId, Integer carsId){
        AbnormalExample example = new AbnormalExample();
        AbnormalExample.Criteria criteria = example.createCriteria();

        if (!status.equals(0)){
            criteria.andStatusEqualTo(1);
        }

        if (!orderId.equals(0)){
            criteria.andOrderIdEqualTo(orderId);
        }

        if (!carsId.equals(0)){
            criteria.andCarIdEqualTo(carsId);
        }

        return abnormalMapper.selectByExample(example);
    }

    public Abnormal findById(Integer id){
        return abnormalMapper.selectByPrimaryKey(id);
    }

    public int processed(Abnormal abnormal){
        return abnormalMapper.updateByPrimaryKeySelective(abnormal);
    }
}
