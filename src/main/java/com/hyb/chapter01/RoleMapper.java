package com.hyb.chapter01;

import org.apache.ibatis.annotations.Select;

/**
 * mapper
 *
 * @author HYB
 * @since 2018/6/9 15:52
 **/
public interface RoleMapper {

    @Select("TRUNCATE TABLE t_role")
    void deleteAll();

    Role selectRole(Long id);

    Long insertRole(Role role);

    void deleteRole(Long id);

    void updateRole(Role role);
}
