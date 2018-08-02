package com.hyb.chapter03.section07.module;

import java.math.BigDecimal;

public class StudentLecture {
    private Integer id;

    private Integer studentId;

    private Integer lectureId;

    /**
     * 学生和课程的一对多级联的中间表
     */
    private Lecture lecture;

    private BigDecimal grade;

    private String note;

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getLectureId() {
        return lectureId;
    }

    public void setLectureId(Integer lectureId) {
        this.lectureId = lectureId;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "StudentLecture{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", lectureId=" + lectureId +
                ", lecture=" + lecture +
                ", grade=" + grade +
                ", note='" + note + '\'' +
                '}';
    }
}