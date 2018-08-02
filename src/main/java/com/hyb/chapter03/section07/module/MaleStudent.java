package com.hyb.chapter03.section07.module;

import java.util.List;

/**
 * TODO
 *
 * @author HYB
 * @since 2018/8/2 23:44
 **/
public class MaleStudent extends Student {
    private List<StudentHealthMale> studentHealthMales;

    public List<StudentHealthMale> getStudentHealthMales() {
        return studentHealthMales;
    }

    public void setStudentHealthMales(List<StudentHealthMale> studentHealthMales) {
        this.studentHealthMales = studentHealthMales;
    }

    @Override
    public String toString() {
        return "MaleStudent{" +
                super.toString() +
                "studentHealthMales=" + studentHealthMales +
                '}';
    }
}
