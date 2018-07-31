package com.hyb.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * 生成sqlSessionFactory
 *
 * @author HYB
 * @since 2018/6/9 14:23
 */

public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory = null;
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SqlSessionFactoryUtil.class);

    private SqlSessionFactoryUtil() {

    }

    /**
     * 单例模式构建工厂
     */
    private static void initSqlSessionFactory(String mybatisConfigPath) {

        InputStream inputStream = null;
//        String resource = "chapter01/mybatis-config.xml";
        try {
            inputStream = Resources.getResourceAsStream(mybatisConfigPath);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        synchronized (CLASS_LOCK) {
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
    }

    /**
     * 返回sqlsession
     *
     * @return
     */
    public static SqlSession openSqlSession(String mybatisConfigPath) {
        if (sqlSessionFactory == null) {
            initSqlSessionFactory(mybatisConfigPath);
        }
        return sqlSessionFactory.openSession();
    }
}
