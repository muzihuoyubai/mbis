package com.hyb.chapter03.section04;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义的typehandler，将枚举的description string作为内容进行转换存入数据库
 *
 * @author HYB
 * @since 2018/6/18 17:19
 **/
public class EnumDescTypeHandlerImpl implements TypeHandler<Sex> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Sex sex, JdbcType jdbcType) throws SQLException {
        String sexName;
        if (sex == null) {
            sexName = Sex.UNKNOWN.getName();
        } else {
            sexName = sex.getName();
        }
        preparedStatement.setString(i, sexName);
    }

    @Override
    public Sex getResult(ResultSet resultSet, String s) throws SQLException {
        String name = resultSet.getString(s);
        return Sex.parse(name);
    }

    @Override
    public Sex getResult(ResultSet resultSet, int i) throws SQLException {
        String name = resultSet.getString(i);
        return Sex.parse(name);
    }

    @Override
    public Sex getResult(CallableStatement callableStatement, int i) throws SQLException {
        String name = callableStatement.getString(i);
        return Sex.parse(name);
    }
}
