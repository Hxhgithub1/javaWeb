package com.hxh.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.hxh.pojo.User;
import com.sun.xml.internal.ws.developer.UsesJAXBContext;
import org.junit.Test;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            // 读 取 jdbc.properties 属 性 配 置 文 件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从 流 中 加 载 数 据
            properties.load(inputStream);
            // 创 建 数 据 库 连 接 池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /** * 获 取 数 据 库 连 接 池 中 的 连 接
     * * @return 如 果 返 回 null,
     *  说 明 获 取 连 接 失 败 <br/> 有 值 就
     *  是 获 取 连 接 成 功 */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关 闭 连 接 ， 放 回 数 据 库 连 接 池 * @param conn
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }
    @Test
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        User user = new User();
        Class aClass = User.class;

        Field[] fields = aClass.getFields();
        Constructor constructor = aClass.getConstructor();
        Object o = constructor.newInstance(user);
        System.out.println(constructor);
        for (Field field:fields
             ) {
            field.setAccessible(true);
            System.out.println(field);

        }
    }


}
