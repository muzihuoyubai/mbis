package com.hyb.chapter03.section07.dao;

import com.hyb.chapter03.section07.module.Lecture;

public interface LectureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lecture record);

    int insertSelective(Lecture record);

    Lecture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Lecture record);

    int updateByPrimaryKey(Lecture record);
}