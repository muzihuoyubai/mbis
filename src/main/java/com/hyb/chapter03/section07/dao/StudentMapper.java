package com.hyb.chapter03.section07.dao;

import com.hyb.chapter03.section07.module.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student selectWithSelfCard(int id);

    Student selectStudentByIdWithInfo(int id);
}