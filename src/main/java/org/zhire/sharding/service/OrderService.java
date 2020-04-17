package org.zhire.sharding.service;

import org.zhire.sharding.model.OrderDO;

/**
 * @Author: chenqi
 * @Date: 2020.4.17 09:51
 */
public interface OrderService {
    public void add(OrderDO order);
    public OrderDO findById(Integer id);
}
