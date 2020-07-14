package com.mapper;

import com.entity.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.InputStream;
import java.util.List;




public class OrderMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectAllOrder() {
        SqlSession session=sqlSessionFactory.openSession();
        OrderMapper orderMaaper=session.getMapper(OrderMapper.class);
        List<Order> orders=orderMaaper.selectAll();
        for (Order order:orders){
            System.out.println(order);
            System.out.println(order.getOrderDetails());
            System.out.println("=====================================================");
        }
    }
}
