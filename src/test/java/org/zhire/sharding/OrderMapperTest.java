package org.zhire.sharding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhire.SpringBootStart;
import org.zhire.sharding.mapper.OrderMapper;
import org.zhire.sharding.model.OrderDO;

import java.util.List;

/**
 * @Author: chenqi
 * @Date: 2020.4.16 16:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStart.class)
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testSelectById() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Test
    public void testSelectListByUserId() {
        List<OrderDO> orders = orderMapper.selectListByUserId(1);
        for (OrderDO order : orders) System.out.println(order);
    }

    @Test
    public void testInsert() {
        OrderDO order = new OrderDO();
        order.setUserId(2);
        orderMapper.insert(order);
    }

}