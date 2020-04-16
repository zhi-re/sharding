package org.zhire.sharding.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.zhire.sharding.model.OrderConfigDO;

/**
 * @Author: chenqi
 * @Date: 2020.4.16 16:02
 */
@Mapper
public interface OrderConfigMapper {
    OrderConfigDO selectById(@Param("id") Integer id);

}
