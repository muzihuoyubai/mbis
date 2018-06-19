package com.hyb.chapter03.section04;

import com.hyb.chapter03.section01.ProcessPropBeforeBuildSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Map;

/**
 * TypeHandler demo
 *
 * @author HYB
 * @since 2018/6/9 23:46
 **/
public class HandlerTest {

    private static final String CONFIG_PATH = "chapter03/section04/mybatis-config.xml";
    private static final String JDBC_PATH = "chapter03/section01/jdbc.properties";

    @Test
    public void test() {

        SqlSession sqlSession = ProcessPropBeforeBuildSqlSessionFactory.openSqlSession(CONFIG_PATH, JDBC_PATH);
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        roleMapper.deleteAll();
        testEnumOrdinalHandler(roleMapper);
        testEnumTypeHandler(roleMapper);
        testDefineBaseTypeHandler(roleMapper);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * baseTypeHandler和typeHandler的实现方式对比
     */
    @Test
    public void nullAbleTypeHandlerTest() {

        SqlSession sqlSession = ProcessPropBeforeBuildSqlSessionFactory.openSqlSession(CONFIG_PATH, JDBC_PATH);
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        roleMapper.deleteAll();

        User defineTypeHandler = new User();
        defineTypeHandler.setNote("test3");
        defineTypeHandler.setRoleName("role name3");
        roleMapper.insertRoleWithNewDefineHandler(defineTypeHandler);
        User userDefineHandlerInserted = roleMapper.selectRoleSexWithNewDefineHandler(defineTypeHandler.getId());
        Map<String, Object> userDefineHandlerInsertedMap = roleMapper.selectRoleSexWithString(defineTypeHandler.getId());
        System.out.println("**********extends baseTypeHandler************");
        System.out.println(userDefineHandlerInserted);
        System.out.println(userDefineHandlerInsertedMap);


        User typeHandlerImplUser = new User();
        typeHandlerImplUser.setNote("test3");
        typeHandlerImplUser.setRoleName("role name3");
        roleMapper.insertRoleWithTypeHandlerImpl(typeHandlerImplUser);
        User typeHandlerImpInserted = roleMapper.selectRoleSexWithTypeHandlerImpl(typeHandlerImplUser.getId());
        Map<String, Object> typeHandlerImpInsertedMap = roleMapper.selectRoleSexWithString(typeHandlerImplUser.getId());
        System.out.println("**********extends baseTypeHandler************");
        System.out.println(typeHandlerImpInserted);
        System.out.println(typeHandlerImpInsertedMap);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * baseTypeHandler和typeHandler的实现方式对比
     * 对于数据库中有null的数据，查询后的处理方式
     */
    @Test
    public void nullSelectTest() {

        SqlSession sqlSession = ProcessPropBeforeBuildSqlSessionFactory.openSqlSession(CONFIG_PATH, JDBC_PATH);
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//        roleMapper.deleteAll();

        User defineTypeHandler = new User();
        defineTypeHandler.setNote("test3");
        defineTypeHandler.setRoleName("role name3");
        roleMapper.insertRoleWithNewDefineHandler(defineTypeHandler);
        User userDefineHandlerInserted = roleMapper.selectRoleSexWithNewDefineHandler(1L);
        Map<String, Object> userDefineHandlerInsertedMap = roleMapper.selectRoleSexWithString(1L);
        System.out.println("**********extends baseTypeHandler************");
        System.out.println(userDefineHandlerInserted);
        System.out.println(userDefineHandlerInsertedMap);


//        User typeHandlerImplUser = new User();
//        typeHandlerImplUser.setNote("test3");
//        typeHandlerImplUser.setRoleName("role name3");
//        roleMapper.insertRoleWithTypeHandlerImpl(typeHandlerImplUser);
        User typeHandlerImpInserted = roleMapper.selectRoleSexWithTypeHandlerImpl(1L);
        Map<String, Object> typeHandlerImpInsertedMap = roleMapper.selectRoleSexWithString(1L);
        System.out.println("**********impl TypeHandler************");
        System.out.println(typeHandlerImpInserted);
        System.out.println(typeHandlerImpInsertedMap);

        sqlSession.close();
    }

    private void testDefineBaseTypeHandler(RoleMapper roleMapper) {
        User defineTypeHandler = new User();
        defineTypeHandler.setNote("test3");
        defineTypeHandler.setRoleName("role name3");
        defineTypeHandler.setSex(Sex.MALE);
        roleMapper.insertRoleWithNewDefineHandler(defineTypeHandler);
        User userDefineHandlerInserted = roleMapper.selectRoleSexWithNewDefineHandler(defineTypeHandler.getId());
        Map<String, Object> userDefineHandlerInsertedMap = roleMapper.selectRoleSexWithString(defineTypeHandler.getId());
        System.out.println("**********NewDefinelHandler************");
        System.out.println(userDefineHandlerInserted);
        System.out.println(userDefineHandlerInsertedMap);
    }

    private void testEnumTypeHandler(RoleMapper roleMapper) {
        User userEnumTypeHandler = new User();
        userEnumTypeHandler.setNote("test2");
        userEnumTypeHandler.setRoleName("role name2");
        userEnumTypeHandler.setSex(Sex.MALE);
        roleMapper.insertRoleWithEnumTypeHandler(userEnumTypeHandler);
        User userEnumTypeHandlerInserted = roleMapper.selectRoleSexWithEnumTypeHandler(userEnumTypeHandler.getId());
        Map<String, Object> userEnumTypeHandlerInsertedMap = roleMapper.selectRoleSexWithString(userEnumTypeHandler.getId());
        System.out.println("**********EnumTypeHandler************");
        System.out.println(userEnumTypeHandlerInserted);
        System.out.println(userEnumTypeHandlerInsertedMap);
    }

    private void testEnumOrdinalHandler(RoleMapper roleMapper) {
        User user = new User();
        user.setNote("test1");
        user.setRoleName("role name");
        user.setSex(Sex.MALE);
        roleMapper.insertRoleWithEnumOrdinalHandler(user);
        User insertUser = roleMapper.selectRoleSexWithEnumOrdinalHandler(user.getId());
        Map<String, Object> userMap = roleMapper.selectRoleSexWithString(user.getId());
        System.out.println("**********EnumOrdinalHandler************");
        System.out.println(insertUser);
        System.out.println(userMap);
    }
}
