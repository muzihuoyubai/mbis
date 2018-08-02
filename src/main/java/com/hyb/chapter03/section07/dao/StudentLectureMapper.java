package com.hyb.chapter03.section07.dao;

import com.hyb.chapter03.section07.module.StudentLecture;

import java.util.List;

public interface StudentLectureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentLecture record);

    int insertSelective(StudentLecture record);

    StudentLecture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentLecture record);

    int updateByPrimaryKey(StudentLecture record);

    List<StudentLecture> selectByStudentId(String studentId);
}