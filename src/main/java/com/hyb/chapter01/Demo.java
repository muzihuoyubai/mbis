package com.hyb.chapter01;

import com.hyb.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 增删改查demo
 *
 * @author HYB
 * @since 2018/6/9 14:04
 **/
public class Demo {

    private static final String CONFIG_PATH = "chapter01/mybatis-config.xml";

    @Test
    public void allTest() {

        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession(CONFIG_PATH);
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
