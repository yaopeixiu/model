package com.example.demo0116.controller;

import com.example.demo0116.domain.Cars;
import com.example.demo0116.domain.OrderDetail;
import com.example.demo0116.domain.Orders;
import com.example.demo0116.service.CarsService;
import com.example.demo0116.service.DriverService;
import com.example.demo0116.service.OrderService;
import com.example.demo0116.util.JacksonUtil;
import com.example.demo0116.util.ResponseUtil;
import com.example.demo0116.validator.Sort;
import com.example.demo0116.validator.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CarsService carsService;
    @Autowired
    private DriverService driverService;

    @PostMapping("OrdersList")
    @CrossOrigin(maxAge = 3600)
    public Object findOrders(String address,
                             @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer limit,
                             @Sort @RequestParam(defaultValue = "add_time") String sort,
                             @Order @RequestParam(defaultValue = "asc") String order){
        List<Orders> ordersList = orderService.findOrders(address, page, limit, sort, order);
        List resultList = new ArrayList();
        for(Orders o : ordersList){
            Map<String, Object> data = new HashMap<>();
            data.put("orderId", o.getOrderId());
            data.put("address", o.getAddress());
            data.put("mobile", o.getMobile());
            OrderDetail orderDetail = orderService.findDetailByOrderId(o.getOrderId());
            data.put("driverName", orderDetail.getDriverName());
            data.put("driverMobile", orderDetail.getDriverMobile());
            data.put("carId", orderDetail.getCarId());
            resultList.add(data);
    }
        return ResponseUtil.okList(resultList, ordersList);
    }

    @PostMapping("add")
    public Object add(@RequestBody String body){
        String address = JacksonUtil.parseString(body, "address");
        String mobile= JacksonUtil.parseString(body, "mobile");
        Integer carId = JacksonUtil.parseInteger(body, "carId");
        Cars car = carsService.findById(carId);
        Orders order = new Orders();
        order.setAddress(address);
        order.setMobile(mobile);
        if (orderService.add(order) != 1){
            return ResponseUtil.fail(200, "订单更新失败");
        }
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setCarId(carId);
        orderDetail.setDriverId(car.getDriverId());
        orderDetail.setDriverMobile(driverService.findById(car.getDriverId()).getMobile());
        orderDetail.setDriverName(driverService.findById(car.getDriverId()).getRealname());
        orderDetail.setOrderId(order.getOrderId());
        if (orderService.addOrderDetail(orderDetail) != 1){
            return ResponseUtil.fail(200, "订单更新失败");
        }
        return ResponseUtil.ok();
    }

    @PostMapping("modify")
    public Object modify(@RequestBody Orders order){
        if (orderService.updateById(order) == 1){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(200, "修改失败");
        }
    }
}
