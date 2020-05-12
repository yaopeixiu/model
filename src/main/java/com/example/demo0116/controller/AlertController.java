package com.example.demo0116.controller;

import com.example.demo0116.domain.Abnormal;
import com.example.demo0116.service.AlertService;
import com.example.demo0116.util.JacksonUtil;
import com.example.demo0116.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alert")
public class AlertController {
    @Autowired
    private AlertService alertService;

    @PostMapping("getAlert")
    @CrossOrigin(maxAge = 3600)
    public Object getAlert(@RequestBody String body){
        Integer status = JacksonUtil.parseInteger(body, "status");
        Integer orderId = JacksonUtil.parseInteger(body, "orderId");
        Integer carsId = JacksonUtil.parseInteger(body, "carsId");
        List<Abnormal> abnormalList = alertService.findalerts(status, orderId, carsId);
        for (Abnormal a : abnormalList){

        }
        return ResponseUtil.okList(abnormalList);
    }

    @PostMapping("processed")
    @CrossOrigin(maxAge = 3600)
    public Object processed(@RequestBody String body){
        Integer id = JacksonUtil.parseInteger(body, "id");
        Abnormal abnormal = alertService.findById(id);
        abnormal.setStatus(1);
        if (alertService.processed(abnormal) == 0){
            return ResponseUtil.fail(200, "更新失败");
        }
        return ResponseUtil.ok();
    }
}
