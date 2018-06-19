package com.hyb.chapter03.section04;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

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
public class EnumDescTypeHandler extends BaseTypeHandler<Sex> {
    /**
     * 传入Sex如果为Null，该函数不会触发，也就是说传入的参数一定是非空的
     *
     * @param preparedStatement
     * @param i
     * @param sex
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Sex sex, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, sex.getName());
    }

    @Override
    public Sex getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String sex = resultSet.getString(s);
        return Sex.parse(sex);
    }

    @Override
    public Sex getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String sex = resultSet.getString(i);
        return Sex.parse(sex);
    }

    @Override
    public Sex getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String sex = callableStatement.getString(i);
        return Sex.parse(sex);
    }
}
