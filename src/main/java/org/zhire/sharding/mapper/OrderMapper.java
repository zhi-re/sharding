package org.zhire.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zhire.sharding.model.OrderDO;

import java.util.List;

/**
 * @Author: chenqi
 * @Date: 2020.4.16 16:00
 */
@Mapper
public interface OrderMapper  extends BaseMapper<OrderDO> {
    OrderDO selectById(@Param("id") Integer id);

    List<OrderDO> selectListByUserId(@Param("userId") Integer userId);

  //  void insert(OrderDO order);
}
