package org.zhire.sharding.model;

/**
 * @Author: chenqi
 * @Date: 2020.4.16 15:58
 */
public class OrderConfigDO {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 支付超时时间
     *
     * 单位：分钟
     */
    private Integer payTimeout;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPayTimeout() {
        return payTimeout;
    }

    public void setPayTimeout(Integer payTimeout) {
        this.payTimeout = payTimeout;
    }
}
