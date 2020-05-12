package com.example.demo0116.controller;

import com.example.demo0116.domain.Cars;
import com.example.demo0116.domain.Driver;
import com.example.demo0116.service.CarsService;
import com.example.demo0116.service.DriverService;
import com.example.demo0116.util.JacksonUtil;
import com.example.demo0116.util.ResponseUtil;
import com.example.demo0116.validator.Order;
import com.example.demo0116.validator.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cars")
public class CarsController {
    @Autowired
    private CarsService carsService;
    @Autowired
    private DriverService driverService;

    @PostMapping("getOnCars")
    @CrossOrigin(maxAge = 3600)
    public Object getOnCars(){
        List<Cars> carsList = carsService.getOnCars();
        List resultList = new ArrayList();
        for(Cars c : carsList){
            Map<String, Object> data = new HashMap<>();
            data.put("carId", c.getCarsId());
            data.put("model", c.getModel());
            data.put("status", c.getStatus());
            Driver driver = driverService.findById(c.getDriverId());
            if (driver != null){
                data.put("driverName", driver.getRealname());
            }
            resultList.add(data);
        }
        return ResponseUtil.okList(resultList, carsList);
    }

    @PostMapping("carList")
    @CrossOrigin(maxAge = 3600)
    public Object carList(@RequestBody String body,
                          @RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer limit){
        String model = JacksonUtil.parseString(body, "model");
        Integer driverId = JacksonUtil.parseInteger(body, "driverId");
        String license = JacksonUtil.parseString(body, "license");
        List<Cars> carsList = carsService.getCars(model, driverId, license, page, limit);
        List resultList = new ArrayList();
        for (Cars c : carsList){
            Map<String, Object> data = new HashMap<>();
            data.put("carsId", c.getCarsId());
            data.put("model", c.getModel());
            data.put("status", c.getStatus());
            data.put("licenseNumber", c.getLicenseNumber());
            data.put("frameNumber", c.getFrameNumber());
            if (c.getDriverId() != null){
                Driver driver = driverService.findById(c.getDriverId());
                data.put("driverName", driver.getRealname());
                data.put("driverId", c.getDriverId());
                data.put("driverMobile", driver.getMobile());
            }
            resultList.add(data);
        }
        return ResponseUtil.okList(resultList, carsList);
    }

    @PostMapping("addCar")
    @CrossOrigin(maxAge = 3600)
    public Object addCar(@RequestBody Cars car){
        if (carsService.addCar(car) == 0){
            return ResponseUtil.fail(200, "添加车辆失败");
        }
        return ResponseUtil.ok();
    }

    @PostMapping("updateCar")
    @CrossOrigin(maxAge = 3600)
    public Object updateCar(@RequestBody Cars car){
//        System.out.println(car.getCarsId());
        if (carsService.updateCar(car) == 0){
            return ResponseUtil.fail(200, "更新车辆失败");
        }
        return ResponseUtil.ok();
    }

    @PostMapping("deleteCar")
    @CrossOrigin(maxAge = 3600)
    public Object deleteCar(@RequestBody String body){
        Integer carsId = JacksonUtil.parseInteger(body, "carsId");
        Cars car = carsService.findById(carsId);
        car.setLogdelete(true);
        if (carsService.updateCar(car) == 0){
            return ResponseUtil.fail(200, "更新车辆失败");
        }
        return ResponseUtil.ok();
    }
}
