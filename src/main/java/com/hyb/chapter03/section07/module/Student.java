package com.hyb.chapter03.section07.module;

public class Student {
    private Integer id;

    private String cnname;

    private Byte sex;

    private Integer selfcardNo;

    private String note;

    /**
     * 学生证，一对一级联
     */
    private StudentSelfCard studentSelfCard;

    public StudentSelfCard getStudentSelfCard() {
        return studentSelfCard;
    }

    public void setStudentSelfCard(StudentSelfCard studentSelfCard) {
        this.studentSelfCard = studentSelfCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Integer getSelfcardNo() {
        return selfcardNo;
    }

    public void setSelfcardNo(Integer selfcardNo) {
        this.selfcardNo = selfcardNo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", cnname='" + cnname + '\'' +
                ", sex=" + sex +
                ", selfcardNo=" + selfcardNo +
                ", note='" + note + '\'' +
                ", studentSelfCard=" + studentSelfCard +
                '}';
    }
}