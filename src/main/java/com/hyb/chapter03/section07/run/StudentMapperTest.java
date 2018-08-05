package com.hyb.chapter03.section07.run;

import com.hyb.chapter03.section07.dao.*;
import com.hyb.chapter03.section07.module.*;
import com.hyb.util.SqlSessionFactoryUtil;
import com.hyb.util.RandomObjectFiller;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * TODO
 *
 * @author HYB
 * @since 2018/8/1 0:56
 **/
public class StudentMapperTest {

    private static final String CONFIG_PATH = "chapter03/section07/mybatis-config.xml";

    @Test
    public void associationTest() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession(CONFIG_PATH);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        RandomObjectFiller randomObjectFiller = new RandomObjectFiller();
        Student insertStudent = randomObjectFiller.createAndFill(Student.class);
        studentMapper.insert(insertStudent);

        StudentSelfCardMapper studentSelfCardMapper = sqlSession.getMapper(StudentSelfCardMapper.class);
        StudentSelfCard insertStudentSelfCard = randomObjectFiller.createAndFill(StudentSelfCard.class);

        insertStudentSelfCard.setStudentId(insertStudent.getId());
        studentSelfCardMapper.insert(insertStudentSelfCard);
        sqlSession.commit();
        Student selectStudent = studentMapper.selectWithSelfCard(insertStudent.getId());
        System.out.println(selectStudent);
    }

    @Test
    public void collectionTest() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession(CONFIG_PATH);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        RandomObjectFiller randomObjectFiller = new RandomObjectFiller();
        Student insertStudent = randomObjectFiller.createAndFill(Student.class);
        studentMapper.insert(insertStudent);

        Lecture lecture = randomObjectFiller.createAndFill(Lecture.class);
        Lecture lecture1 = randomObjectFiller.createAndFill(Lecture.class);
        LectureMapper lectureMapper = sqlSession.getMapper(LectureMapper.class);
        lectureMapper.insert(lecture);
        lectureMapper.insert(lecture1);

        StudentLecture studentLecture = new StudentLecture();
        StudentLectureMapper studentLectureMapper = sqlSession.getMapper(StudentLectureMapper.class);
        studentLecture.setLectureId(lecture.getId());
        studentLecture.setStudentId(insertStudent.getId());
        studentLectureMapper.insert(studentLecture);

        StudentLecture studentLecture1 = new StudentLecture();
        studentLecture1.setLectureId(lecture1.getId());
        studentLecture1.setStudentId(insertStudent.getId());
        studentLectureMapper.insert(studentLecture1);

        sqlSession.commit();
        Student selectStudent = studentMapper.selectWithSelfCard(insertStudent.getId());
        System.out.println(selectStudent);
        System.out.println(selectStudent.getLectures().size());
    }


    @Test
    public void discriminatorTest() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession(CONFIG_PATH);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        RandomObjectFiller randomObjectFiller = new RandomObjectFiller();
        Student insertStudent = randomObjectFiller.createAndFill(Student.class);
        insertStudent.setSex(1);
        studentMapper.insert(insertStudent);

        StudentHealthMale studentHealthMale = randomObjectFiller.createAndFill(StudentHealthMale.class);
        studentHealthMale.setStudentId(insertStudent.getId());
        StudentHealthMaleMapper studentHealthMaleMapper = sqlSession.getMapper(StudentHealthMaleMapper.class);
        studentHealthMaleMapper.insert(studentHealthMale);


        Student insertStudentFemale = randomObjectFiller.createAndFill(Student.class);
        insertStudentFemale.setSex(2);
        studentMapper.insert(insertStudentFemale);

        StudentHealthFemale studentHealthFemale = randomObjectFiller.createAndFill(StudentHealthFemale.class);
        studentHealthFemale.setStudentId(insertStudentFemale.getId());
        StudentHealthFemaleMapper studentHealthFemaleMapper = sqlSession.getMapper(StudentHealthFemaleMapper.class);
        studentHealthFemaleMapper.insert(studentHealthFemale);

        sqlSession.commit();
        Student selectStudent = studentMapper.selectWithSelfCard(insertStudent.getId());
        System.out.println(selectStudent);

        Student female = studentMapper.selectWithSelfCard(insertStudentFemale.getId());

        System.out.println(female);
    }

    @Test
    public void selectOneWithInfo() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession(CONFIG_PATH);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

//        Student student = studentMapper.selectStudentByIdWithInfo(19);
        Student student = studentMapper.selectStudentByIdWithInfo(11);
        System.out.println(student);
    }
}