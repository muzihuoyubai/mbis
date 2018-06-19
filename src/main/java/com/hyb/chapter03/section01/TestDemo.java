package com.hyb.chapter03.section01;

import com.hyb.chapter01.Role;
import com.hyb.chapter01.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * 属性的配置demo
 *
 * @author HYB
 * @since 2018/6/9 23:46
 **/
public class TestDemo {

    private static final String CONFIG_PATH = "chapter03/section01/mybatis-config.xml";
    private static final String JDBC_PATH = "chapter03/section01/jdbc.properties";

    @Test
    public void test() {

        SqlSession sqlSession = ProcessPropBeforeBuildSqlSessionFactory.openSqlSession(CONFIG_PATH,JDBC_PATH);
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        roleMapper.deleteAll();
        Role role = new Role();
        role.setNote("test1");
        role.setRoleName("role name");
        roleMapper.insertRole(role);
        Long id = role.getId();
        assertEquals(new Long(1), id);

        Role selectRole = roleMapper.selectRole(id);
        assertEquals(role, selectRole);

        selectRole.setRoleName("changeName");
        selectRole.setNote("change note");
        roleMapper.updateRole(selectRole);

        Role selectUpdate = roleMapper.selectRole(id);
        assertEquals(selectUpdate, selectRole);

        roleMapper.deleteRole(id);
        Role selectAgain = roleMapper.selectRole(id);
        assertNull(selectAgain);

        sqlSession.commit();
        sqlSession.close();
    }
}
