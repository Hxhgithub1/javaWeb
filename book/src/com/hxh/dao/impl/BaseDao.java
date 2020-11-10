package com.hxh.dao.impl;

import com.hxh.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public abstract class BaseDao {
    private QueryRunner queryRunner =  new QueryRunner();
    /**
     * 返回-1表示执行失败，返回其他表示影响的行数
     */
    public int update(String sql,Object ...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return  -1;
    }

    /**
     *
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T>T   queryForOne(Class<T> type,String sql,Object ...args){
        Connection connection =JdbcUtils.getConnection();
        try {

            return  queryRunner.query(connection, sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    public <T>List<T> queryForList(Class<T> type,String sql,Object ...args){
        Connection connection = JdbcUtils.getConnection();
        try {
           return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 执行返回一行一列的sql
     * @param sql
     * @param args  
     * @return
     */

    public Object queryForSingleValues(String sql,Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

}
