package com.hyb.chapter03.section07.dao;

import com.hyb.chapter03.section07.module.StudentHealthFemale;

public interface StudentHealthFemaleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentHealthFemale record);

    int insertSelective(StudentHealthFemale record);

    StudentHealthFemale selectByPrimaryKey(Integer id);

    StudentHealthFemale selectByStudentId(Integer id);

    int updateByPrimaryKeySelective(StudentHealthFemale record);

    int updateByPrimaryKey(StudentHealthFemale record);
}