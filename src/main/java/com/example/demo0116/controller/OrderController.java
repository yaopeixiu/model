package com.example.demo0116.controller;

import com.example.demo0116.domain.Cars;
import com.example.demo0116.domain.Driver;
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

import java.time.LocalDateTime;
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
    public Object findOrders(@RequestBody String body,
                             @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer limit,
                             @Sort @RequestParam(defaultValue = "add_time") String sort,
                             @Order @RequestParam(defaultValue = "asc") String order){
        String address = JacksonUtil.parseString(body, "address");
        String mobile = JacksonUtil.parseString(body, "mobile");
        String name = JacksonUtil.parseString(body, "name");
        List<Orders> ordersList = orderService.findOrders(address, mobile, name, page, limit, sort, order);
        List resultList = new ArrayList();
        for(Orders o : ordersList){
            Map<String, Object> data = new HashMap<>();
            data.put("orderId", o.getOrderId());
            data.put("address", o.getAddress());
            data.put("mobile", o.getMobile());
            data.put("type", o.getType());
            data.put("name", o.getName());
            OrderDetail orderDetail = orderService.findDetailByOrderId(o.getOrderId());
            data.put("driverName", orderDetail.getDriverName());
            data.put("driverMobile", orderDetail.getDriverMobile());
            data.put("carId", orderDetail.getCarId());
            resultList.add(data);
    }
        return ResponseUtil.okList(resultList, ordersList);
    }

    @PostMapping("add")
    @CrossOrigin(maxAge = 3600)
    public Object add(@RequestBody String body){
        String addr = JacksonUtil.parseString(body, "addr");
        String province = JacksonUtil.parseString(body, "province");
        String city = JacksonUtil.parseString(body, "city");
        String area = JacksonUtil.parseString(body, "area");
        String address = province + city + area + addr;
        String mobile= JacksonUtil.parseString(body, "mobile");
        String name= JacksonUtil.parseString(body, "name");
//        Integer carId = JacksonUtil.parseInteger(body, "carId");
//        Cars car = carsService.findById(carId);
        Orders order = new Orders();
        order.setAddress(address);
        order.setName(name);
        order.setMobile(mobile);
        if (orderService.add(order) != 1){
            return ResponseUtil.fail(200, "订单更新失败");
        }
        OrderDetail orderDetail = new OrderDetail();
//        orderDetail.setCarId(carId);
//        orderDetail.setDriverId(car.getDriverId());
//        orderDetail.setDriverMobile(driverService.findById(car.getDriverId()).getMobile());
//        orderDetail.setDriverName(driverService.findById(car.getDriverId()).getRealname());
        orderDetail.setOrderId(order.getOrderId());
        if (orderService.addOrderDetail(orderDetail) != 1){
            return ResponseUtil.fail(200, "订单更新失败");
        }
        return ResponseUtil.ok();
    }

    @PostMapping("modify")
    @CrossOrigin(maxAge = 3600)
    public Object modify(@RequestBody Orders order){
        Orders orders = orderService.findOrderById(order.getOrderId());
        if (orders == null){
            return ResponseUtil.fail(200, "参数错误");
        }
        if (orderService.updateById(order) == 1){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(200, "修改失败");
        }
    }

    @PostMapping("delete")
    @CrossOrigin(maxAge = 3600)
    public Object delete(@RequestBody Map map){
        int id = Integer.parseInt(map.get("id").toString());
        System.out.println(id);
        Orders order = orderService.findOrderById(id);
        if(order == null)
            return ResponseUtil.badArgumentValue();
        order.setLogdelete(true);
        if(orderService.updateById(order) == 1){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(200, "删除失败");
        }
    }

    @PostMapping("assignOrder")
    @CrossOrigin(maxAge = 3600)
    public Object assignOrder(@RequestBody String body) {
        Integer carsId = JacksonUtil.parseInteger(body, "carsId");
        Integer orderId = JacksonUtil.parseInteger(body, "orderId");
        Cars car = carsService.findById(carsId);
        car.setStatus(1);
        carsService.updateCar(car);
        Driver driver = driverService.findById(car.getDriverId());
        OrderDetail orderDetail = orderService.findDetailByOrderId(orderId);
        orderDetail.setDriverName(driver.getRealname());
        orderDetail.setDriverMobile(driver.getMobile());
        orderDetail.setDriverId(driver.getDriverId());
        orderDetail.setCarId(carsId);
        orderService.updateDetail(orderDetail);
        Orders order = orderService.findOrderById(orderId);
        order.setType(true);
        order.setUpdateTime(LocalDateTime.now());
        orderService.updateById(order);
        return ResponseUtil.ok();
    }
}
