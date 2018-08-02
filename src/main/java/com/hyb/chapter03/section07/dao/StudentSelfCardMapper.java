package com.hyb.chapter03.section07.dao;

import com.hyb.chapter03.section07.module.StudentSelfCard;

public interface StudentSelfCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentSelfCard record);

    int insertSelective(StudentSelfCard record);

    StudentSelfCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentSelfCard record);

    int updateByPrimaryKey(StudentSelfCard record);

    /**
     * 一对一级联
     *
     * @param studentId
     * @return
     */
    StudentSelfCard selectByStudentId(String studentId);
}