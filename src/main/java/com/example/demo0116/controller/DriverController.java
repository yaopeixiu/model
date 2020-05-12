package com.example.demo0116.controller;

import com.example.demo0116.domain.Driver;
import com.example.demo0116.service.DriverService;
import com.example.demo0116.util.JacksonUtil;
import com.example.demo0116.util.ResponseUtil;
import com.example.demo0116.validator.Order;
import com.example.demo0116.validator.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    DriverService driverService;

    @PostMapping("driverList")
    @CrossOrigin(maxAge = 3600)
    public Object driverList(@RequestBody String body,
                             @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer limit,
                             @Sort @RequestParam(defaultValue = "add_time") String sort,
                             @Order @RequestParam(defaultValue = "asc") String order){
        String realName = JacksonUtil.parseString(body, "realName");
        String mobile = JacksonUtil.parseString(body, "mobile");
        String card = JacksonUtil.parseString(body, "card");
        List<Driver> driverList = driverService.findDriver(realName, mobile, card,  page, limit, sort, order);
        return ResponseUtil.okList(driverList);
        }

    @PostMapping("addDriver")
    @CrossOrigin(maxAge = 3600)
    public Object addDriver(@RequestBody Driver driver){
        if (driverService.addDriver(driver) == 0){
            return ResponseUtil.fail(200, "添加驾驶员失败");
        }
        return ResponseUtil.ok();
    }

    @PostMapping("updateDriver")
    @CrossOrigin(maxAge = 3600)
    public Object updateDriver(@RequestBody Driver driver){
        driver.setUpdateTime(LocalDateTime.now());
        if (driverService.updateDriver(driver) == 0){
            return ResponseUtil.fail(200, "更新司机信息失败");
        }
        return ResponseUtil.ok();
    }

    @PostMapping("deleteDriver")
    @CrossOrigin(maxAge = 3600)
    public Object deleteDriver(@RequestBody String body){
        Integer driverId = JacksonUtil.parseInteger(body, "driverId");
        Driver driver = driverService.findById(driverId);
        driver.setLogdelete(true);
        driver.setUpdateTime(LocalDateTime.now());
        if (driverService.updateDriver(driver) == 0){
            return ResponseUtil.fail(200, "更新司机信息失败");
        }
        return ResponseUtil.ok();
    }
}
