package com.hyb.chapter03.section07.dao;

import com.hyb.chapter03.section07.module.StudentHealthMale;

public interface StudentHealthMaleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentHealthMale record);

    int insertSelective(StudentHealthMale record);

    StudentHealthMale selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentHealthMale record);

    int updateByPrimaryKey(StudentHealthMale record);
}