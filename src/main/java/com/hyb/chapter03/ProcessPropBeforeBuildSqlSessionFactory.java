package com.hyb.chapter03;

import com.hyb.chapter01.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

/**
 * 处理属性文件的属性字段，处理例如数据库用户名或密码的加密
 *
 * @author HYB
 * @since 2018/6/9 22:58
 **/
public class ProcessPropBeforeBuildSqlSessionFactory {

    private static SqlSessionFactory sqlSessionFactory;
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SqlSessionFactoryUtil.class);

    private ProcessPropBeforeBuildSqlSessionFactory() {

    }

    /**
     * 单例模式构建工厂
     */
    private static void initSqlSessionFactory() {

        Reader cfgReader = null;
        InputStream cfgStream = null;
        InputStream proStream = null;
        Reader proReader = null;
        Properties properties = null;
        try {

            cfgStream = Resources.getResourceAsStream("chapter03/mybatis-config.xml");
            cfgReader = new InputStreamReader(cfgStream);

            proStream = Resources.getResourceAsStream("chapter03/jdbc.properties");
            proReader = new InputStreamReader(proStream);

            properties = new Properties();
            properties.load(proReader);

            //对properties在这里进行处理
            properties.setProperty("username", properties.getProperty("username"));
            properties.setProperty("password", properties.getProperty("password"));
            LOGGER.info("process properties");

        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        synchronized (CLASS_LOCK) {
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(cfgReader, properties);
            }
        }
    }

    /**
     * 返回sqlsession
     *
     * @return
     */
    public static SqlSession openSqlSession() {
        if (sqlSessionFactory == null) {
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
