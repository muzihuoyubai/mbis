package com.hyb.chapter03.section04;

import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * mapper
 *
 * @author HYB
 * @since 2018/6/9 15:52
 **/
public interface RoleMapper {

    @Select("TRUNCATE TABLE t_role")
    void deleteAll();

    /**
     * 查询数据库真正的sex字符串
     *
     * @author HYB
     * @since 2018/6/19 22:08
     */
    Map<String, Object> selectRoleSexWithString(Long id);

    /**
     * EnumOrdinalHandler插入
     *
     * @author HYB
     * @since 2018/6/19 22:09
     */
    void insertRoleWithEnumOrdinalHandler(User user);

    /**
     * EnumOrdinalHandler查询
     *
     * @author HYB
     * @since 2018/6/19 22:09
     */
    User selectRoleSexWithEnumOrdinalHandler(Long id);

    /**
     * EnumTypeHandler插入
     *
     * @author HYB
     * @since 2018/6/19 22:09
     */
    void insertRoleWithEnumTypeHandler(User user);

    /**
     * EnumTypeHandler查询
     *
     * @author HYB
     * @since 2018/6/19 22:09
     */
    User selectRoleSexWithEnumTypeHandler(Long id);

    /**
     * 自定义的typeHandler插入，继承baseTypeHandler
     *
     * @author HYB
     * @since 2018/6/19 22:09
     */
    void insertRoleWithNewDefineHandler(User user);

    /**
     * 自定义的typeHandler查询，继承baseTypeHandler
     *
     * @author HYB
     * @since 2018/6/19 22:09
     */
    User selectRoleSexWithNewDefineHandler(Long id);

    /**
     * 自定义的typeHandler插入，实现了TypeHandler
     *
     * @author HYB
     * @since 2018/6/19 22:09
     */
    void insertRoleWithTypeHandlerImpl(User user);

    /**
     * 自定义的typeHandler查询，实现了TypeHandler
     *
     * @author HYB
     * @since 2018/6/19 22:09
     */
    User selectRoleSexWithTypeHandlerImpl(Long id);

}
