package com.hyb.chapter03.section07.run;

import com.hyb.util.SqlSessionFactoryUtil;
import com.hyb.chapter03.section07.dao.StudentMapper;
import com.hyb.chapter03.section07.dao.StudentSelfCardMapper;
import com.hyb.chapter03.section07.module.Student;
import com.hyb.chapter03.section07.module.StudentSelfCard;
import com.hyb.util.RandomObjectFiller;
import org.apache.ibatis.jdbc.SelectBuilder;
import org.apache.ibatis.jdbc.SqlBuilder;
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
}