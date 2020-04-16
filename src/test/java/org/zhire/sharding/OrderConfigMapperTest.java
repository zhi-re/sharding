package org.zhire.sharding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhire.SpringBootStart;
import org.zhire.sharding.mapper.OrderConfigMapper;
import org.zhire.sharding.model.OrderConfigDO;

import javax.annotation.Resource;

/**
 * @Author: chenqi
 * @Date: 2020.4.16 16:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStart.class)
public class OrderConfigMapperTest {

    @Resource
    private OrderConfigMapper orderConfigMapper;

    @Test
    public void testSelectById() {
        OrderConfigDO orderConfig = orderConfigMapper.selectById(1);
        System.out.println(orderConfig);
    }

}