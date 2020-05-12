package com.example.demo0116.controller;

import com.example.demo0116.domain.Cars;
import com.example.demo0116.domain.Driver;
import com.example.demo0116.domain.Locations;
import com.example.demo0116.service.CarsService;
import com.example.demo0116.service.DriverService;
import com.example.demo0116.service.MapLocationService;
import com.example.demo0116.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/map/location")
public class MapController {
    @Autowired
    private MapLocationService mapLocationService;
    @Autowired
    private CarsService carsService;
    @Autowired
    private DriverService driverService;

    @PostMapping("getLocation")
    @CrossOrigin(maxAge = 3600)
    public Object getLocation(){
        List<Locations> locationsList = mapLocationService.getLocations();
        List resultList = new ArrayList();
        for(Locations l : locationsList){
            Map<String, Object> data = new HashMap<>();
            data.put("status", l.getStatus());
            data.put("lng", l.getLng());
            data.put("lat", l.getLat());
            Cars car = carsService.findById(l.getCarId());
            data.put("licenseNumber", car.getLicenseNumber());
            Driver driver = driverService.findById(car.getDriverId());
            data.put("driverName", driver.getRealname());
            data.put("driverMobile" ,driver.getMobile());
            resultList.add(data);
        }
        return ResponseUtil.okList(resultList, locationsList);
    }
}
