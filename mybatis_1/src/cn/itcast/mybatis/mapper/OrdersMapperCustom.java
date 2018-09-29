package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.User;

import java.util.List;

/**
 * @author hujtb
 * @create on 2018-09-06-17:32
 */
public interface OrdersMapperCustom {
    public List<Orders> selectOrdersUser() throws Exception;
    public List<Orders> selectOrderAndDetails() throws Exception;
    public List<User> selectUserAndItem() throws  Exception;
    public List<Orders> selectOrderUserLazyLoading() throws  Exception;

}
