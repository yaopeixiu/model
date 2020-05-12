package com.example.demo0116.service;

import com.example.demo0116.dao.LocationsMapper;
import com.example.demo0116.domain.Locations;
import com.example.demo0116.domain.LocationsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MapLocationService {
    @Resource
    private LocationsMapper locationsMapper;

    public List<Locations> getLocations(){
        LocationsExample example = new LocationsExample();
        example.or().andAddTimeLessThan(LocalDateTime.now());
        return locationsMapper.selectByExample(example);
    }
}
