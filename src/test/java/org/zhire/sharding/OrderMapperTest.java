package org.zhire.sharding;

import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhire.SpringBootStart;
import org.zhire.sharding.mapper.OrderMapper;
import org.zhire.sharding.model.OrderDO;
import org.zhire.sharding.service.OrderService;

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

    @Autowired
    private OrderService orderService;

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
        order.setUserId(1);
        orderMapper.insert(order);
    }

    @Test
    public void testSelectById2() { // 测试从库的负载均衡
        for (int i = 0; i < 2; i++) {
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    @Test
    public void testSelectById02() { // 测试强制访问主库

       // 在使用完后，需要去清理下 HintManager
       // （HintManager 是基于线程变量，透传给 Sharding-JDBC 的内部实现），避免污染下次请求，一直强制访问主库。
       //  HintManager 实现了 AutoCloseable 接口，可以通过 Try-with-resources 机制，自动关闭。
        try (HintManager hintManager = HintManager.getInstance()) {
            // 设置强制访问主库
            hintManager.setMasterRouteOnly();
            // 执行查询
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    @Test
    public void testAdd(){
        OrderDO orderDO = new OrderDO();
        orderDO.setId(1L);
        orderDO.setUserId(2);
        orderService.add(orderDO);
    }
    @Test
    public void findByid(){
        OrderDO id = orderService.findById(8);
        System.out.println(id);
    }


}