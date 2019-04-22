package com.zhousx.demo;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.ProxyFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.wrappers.SqlNullCheckedResultSet;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class DbUtilsTest {
    public static void main(String[] args){
//        getBeanListData();
//        getMapListData();
        insertAndUpdateData();
    }
    /**
     * BeanListHandler: 将ResultSet中所有的数据转换成List,List中存放的是对象
     */
    public static void getBeanListData(){
        Connection conn = getConnection();
        QueryRunner qr = new QueryRunner();
        try {
            ResultSetHandler rsh = new BeanHandler(User.class);
            User user = (User) qr.query(conn,"select name,age,id from user where id=111",rsh);
            System.out.println(StringUtils.center("findByid",50,'*'));
            System.out.println(user.getAge()+"-"+user.getName());
            List results = qr.query(conn,"select name,age from user",new BeanListHandler<>(User.class));
            System.out.println(StringUtils.center("findAll",50,'*'));
            for (int i =0;i<results.size();i++){
                User user1 = (User) results.get(i);
                System.out.println(user1.getAge() + "-"+user1.getName());
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * MapListHandle; 将ResultSet中所有的数据存成List,List中存放的是Map
     */
    public static void getMapListData(){
        Connection conn = getConnection();
        QueryRunner qr = new QueryRunner();
        try {
            List results = qr.query(conn,"select id,name,age from user",new MapListHandler());
            for (int i=0;i<results.size();i++){
                Map map = (Map) results.get(i);
                System.out.println(map.get("id") + "-"+map.get("name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 新增和更新例子
     */
    public static void insertAndUpdateData(){
        Connection conn = getConnection();
        QueryRunner qr = new QueryRunner();
        try {
            Object[] insertParams = {"5555","sdfsdf","24"};
            int inserts = qr.update(conn,"insert into user(id,name,age) values (?,?,?)",insertParams);
            System.out.println("inserted " + inserts +"data");
            Object[] updateParams = {"sssss",111};
            int updates = qr.update(conn,"update user set name=? where id = ?",updateParams);
            System.out.println("updated "+ updates + "data");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * SqlNullCheckedResultSet 这个类不是线程安全的
     */
    public static void findUseSqlNullCheckResultSet(){
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select id,name,age from user");
            SqlNullCheckedResultSet wrapper = new SqlNullCheckedResultSet(rs);
            wrapper.setNullString("N/A");
            rs = ProxyFactory.instance().createResultSet(wrapper);
            while (rs.next()){
                System.out.println(rs.getInt("id") + "-"+rs.getString("name"));
            }
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3307/demo?useUnicode=true&characterEncoding=gb2312&zeroDateTimeBehavior=convertToNull&useSSL=false";
        DbUtils.loadDriver(driver);
        try {
            conn = DriverManager.getConnection(url,"root","mysql");
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return conn;
    }
}
