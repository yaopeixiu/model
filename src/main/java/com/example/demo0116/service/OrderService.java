package com.example.demo0116.service;

import com.example.demo0116.dao.OrderDetailMapper;
import com.example.demo0116.dao.OrdersMapper;
import com.example.demo0116.domain.OrderDetail;
import com.example.demo0116.domain.OrderDetailExample;
import com.example.demo0116.domain.Orders;
import com.example.demo0116.domain.OrdersExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Transactional
    public int add(Orders order){
        order.setAddTime(LocalDateTime.now());
        return ordersMapper.insertSelective(order);
    }

    public int updateById(Orders order){
        order.setUpdateTime(LocalDateTime.now());
        return ordersMapper.updateByPrimaryKeySelective(order);
    }

    public OrderDetail findDetailById(Integer id){
        return orderDetailMapper.selectByPrimaryKey(id);
    }

    public OrderDetail findDetailByOrderId(Integer id){
        OrderDetailExample example = new OrderDetailExample();
        example.or().andOrderIdEqualTo(id);
        return orderDetailMapper.selectOneByExample(example);
    }

    public int updateDetail(OrderDetail orderDetail){
        return orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
    }

    @Transactional
    public int addOrderDetail(OrderDetail orderDetail){
        return orderDetailMapper.insertSelective(orderDetail);
    }

    public List<Orders> findOrders(String address, Integer page, Integer limit, String sort, String order){
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();

        if (address != null){
            criteria.andAddressLike("%" + address +"%");
        }
        criteria.andLogdeleteEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return ordersMapper.selectByExample(example);
    }

    public Orders findOrderById(Integer id){
        return ordersMapper.selectByPrimaryKey(id);
    }
}
