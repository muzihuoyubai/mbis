package com.hyb.chapter03.section07.module;

import java.util.List;

/**
 * TODO
 *
 * @author HYB
 * @since 2018/8/2 23:47
 **/
public class FemaleStudent extends Student {
    private List<StudentHealthFemale> studentHealthFemales;

    public List<StudentHealthFemale> getStudentHealthFemales() {
        return studentHealthFemales;
    }

    public void setStudentHealthFemales(List<StudentHealthFemale> studentHealthFemales) {
        this.studentHealthFemales = studentHealthFemales;
    }

    @Override
    public String toString() {
        return "FemaleStudent{" +
                super.toString() +
                "studentHealthFemales=" + studentHealthFemales +
                '}';
    }
}
