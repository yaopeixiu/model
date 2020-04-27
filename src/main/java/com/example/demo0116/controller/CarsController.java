package com.example.demo0116.controller;

import com.example.demo0116.domain.Cars;
import com.example.demo0116.domain.Driver;
import com.example.demo0116.service.CarsService;
import com.example.demo0116.service.DriverService;
import com.example.demo0116.util.ResponseUtil;
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
            data.put("driverName", driver.getRealname());
            resultList.add(data);
        }
        return ResponseUtil.okList(resultList, carsList);
    }
}
