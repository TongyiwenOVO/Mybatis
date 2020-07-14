package com.mapper;


import com.entity.QuerryVo;
import com.entity.User;
import com.entity.UserCustom;
import com.sun.deploy.model.Resource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public class UserMapperTest {
    private  SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectAll() {
        SqlSession session=sqlSessionFactory.openSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        List<User> users=mapper.selectAll();
        for (User user:users){
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void selectById(){
        SqlSession session=sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=userMapper.findById(1);
        System.out.println(user);
        session.close();
    }

    @Test
    public void selectByName(){
        SqlSession session=sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        List<User> user=userMapper.findByName("%童%");
        for (User user1:user){
            System.out.println(user1);
        }
        session.close();
    }

    @Test
    public void savaUser(){
        SqlSession session=sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=new User();
        user.setAddress("武昌区");
        user.setUsername("tyw111");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存前"+user);
        userMapper.saveUser(user);
        session.commit();
        System.out.println("保存后"+user);
        session.close();

    }

    @Test
    public void deleteUser(){
        SqlSession session=sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        userMapper.deleteUserById(16);
        session.commit();
        session.close();
    }

    @Test
    public void updateUser(){
        SqlSession session=sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=new User();
        user.setId(15);
        user.setAddress("洪山区");
        user.setUsername("胡宝峰");
        user.setSex("男");
        user.setBirthday(new Date());
        userMapper.updateUser(user);
        session.commit();
        session.close();
    }

    @Test
    public void testQuerryVo(){
        SqlSession session=sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        UserCustom userCustom=new UserCustom();
        userCustom.setUsername("童");
        userCustom.setSex("男");
        List<Integer> ids=new ArrayList<>();
        ids.add(5);
        ids.add(8);
        ids.add(11);
        QuerryVo querryVo=new QuerryVo(userCustom);
        querryVo.setIds(ids);
        List<UserCustom> users=userMapper.selectByQuerryVo(querryVo);
        for (UserCustom userCustom1:users){
            System.out.println(userCustom1);
        }
    }
}
