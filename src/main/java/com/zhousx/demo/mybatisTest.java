package com.zhousx.demo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.SocketChannel;

public class mybatisTest {

    public static void main(String[] args) throws IOException {
        //加载配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（也加载关联的映射文件）
        InputStream is = mybatisTest.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlsession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用mybatis提供的resources类加载mybatis的配置文件（也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串
         */
        String statement = "com.zhousx.mapping.userMapper.getUser";
        User user = session.selectOne(statement, 1);
        System.out.println(user);
    }
}
