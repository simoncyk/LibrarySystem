package com.web.common;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/03/21.
 */
public class TXQueryRunner extends QueryRunner {
    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection con =JdbcUtils.getConnection();
        T result =super.query(con,sql,rsh,params );
        JdbcUtils.reConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con =JdbcUtils.getConnection();
        T result =super.query(con,sql,rsh );
        JdbcUtils.reConnection(con);
        return result;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection con =JdbcUtils.getConnection();
        int result =super.update(con,sql);
        JdbcUtils.reConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection con =JdbcUtils.getConnection();
        int result =super.update(con,sql,param);
        JdbcUtils.reConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection con =JdbcUtils.getConnection();
        int result =super.update(con,sql,params);
        JdbcUtils.reConnection(con);
        return result;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con =JdbcUtils.getConnection();
        T result =super.insert(con,sql,rsh);
        JdbcUtils.reConnection(con);
        return result;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection con =JdbcUtils.getConnection();
        T result =super.insert(con,sql,rsh,params);
        JdbcUtils.reConnection(con);
        return result;
    }

    @Override
    public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) throws SQLException {
        Connection con =JdbcUtils.getConnection();
        T result =super.insertBatch(con,sql,rsh,params);
        JdbcUtils.reConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh) throws SQLException {
        Connection con =JdbcUtils.getConnection();
        T result =super.query(con,sql,params,rsh);
        JdbcUtils.reConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) throws SQLException {
        Connection con =JdbcUtils.getConnection();
        T result =super.query(con,sql,param,rsh);
        JdbcUtils.reConnection(con);
        return result;
    }

    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        Connection con =JdbcUtils.getConnection();
        int[] result =super.batch(con,sql,params);
        JdbcUtils.reConnection(con);
        return result;
    }
}
