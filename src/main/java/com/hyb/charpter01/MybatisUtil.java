package com.hyb.charpter01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 生成sqlSessionFactory
 *
 * @author HYB
 * @since 2018/6/9 14:23
 **/
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            String resource = "charpter01/mybatis-config.xml";
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
                return sqlSessionFactory;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }
}
