package org.zhire.sharding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhire.sharding.mapper.OrderMapper;
import org.zhire.sharding.model.OrderDO;
import org.zhire.sharding.service.OrderService;

/**
 * @Author: chenqi
 * @Date: 2020.4.17 09:52
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void add(OrderDO order) {
        //  读取从库
        OrderDO exists = orderMapper.selectById(1);
        System.out.println(exists);

        //  插入订单到主库
        orderMapper.insert(order);

        // 同一个线程有写入了主库，则后面也会从主库读取，保证数据一致性
        exists = orderMapper.selectById(1);
        System.out.println(exists);
    }

    @Override
    public OrderDO findById(Integer id) {
        return orderMapper.selectById(id);
    }
}
