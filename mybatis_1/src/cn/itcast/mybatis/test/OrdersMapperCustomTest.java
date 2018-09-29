package cn.itcast.mybatis.test;

import cn.itcast.mybatis.mapper.OrdersMapperCustom;
import cn.itcast.mybatis.po.OrderDetails;
import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @author hujtb
 * @create on 2018-09-06-17:49
 */
public class OrdersMapperCustomTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

    }
    @Test
    public void testSelectOrderUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
        List<Orders> list =  ordersMapperCustom.selectOrdersUser();
        Iterator<Orders> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getUser());
        }
    }
    @Test
    public void testSelectOrderAndDetails() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
        List<Orders> list =  ordersMapperCustom.selectOrderAndDetails();
        Iterator<Orders> orderIt = list.iterator();
        while(orderIt.hasNext()){
            Iterator<OrderDetails> odIt = orderIt.next().getDetailsList().iterator();
            while(odIt.hasNext()){
                System.out.println(odIt.next().getId());
            }
        }
    }
    @Test
    public void testSelectUserAndItem() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
        List<User> list =  ordersMapperCustom.selectUserAndItem();
        System.out.println(list);
    }
    @Test
    public void testSelectOrderUserLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
        List<Orders> list =  ordersMapperCustom.selectOrderUserLazyLoading();
        for(Orders order : list) {
            //按需加载
            User user = order.getUser();
            System.out.println(user);
        }
    }
}
