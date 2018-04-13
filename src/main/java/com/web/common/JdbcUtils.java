package com.web.common;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Administrator on 2018/03/15.
 */
public class JdbcUtils {

    private  static ThreadLocal<  Connection> t1 = new ThreadLocal<Connection>();
    private static ComboPooledDataSource datasource =new  ComboPooledDataSource();
    public static  Connection getConnection() throws SQLException{
        try {
            Connection con= t1.get();
            if (con!=null) return con;
            return  datasource.getConnection();
        }catch (Exception e){

            throw  new  RuntimeException(e.toString());
        }
    }
    public static DataSource getdatasource() throws SQLException{

        return datasource;
    }

    public static  void beginTransaction() throws SQLException {
            Connection con= t1.get();
        if (con!=null){

            throw  new SQLException("事物以开始,不能重复开启");
        }

            con = getConnection();
            con.setAutoCommit(false);
           t1.set(con);

    }
    public static  void commitTransaction () throws SQLException  {
        Connection con= t1.get();
        if (con==null){

            throw  new SQLException("还没开始事物,不能提交");
        }
        con.commit();
        con.close();

        t1.remove();
    }
    public static  void rollbackTransaction() throws SQLException  {
        Connection con= t1.get();
        if (con==null){

            throw  new SQLException("还没开始事物,不能回滚");
        }
          con.rollback();
          con.close();
           t1.remove();
    }

    public static  void  reConnection( Connection Connection) throws SQLException{
        Connection con= t1.get();
        if (con == null)  Connection.close();
        if  (con!=Connection) Connection .close();
    }

}
