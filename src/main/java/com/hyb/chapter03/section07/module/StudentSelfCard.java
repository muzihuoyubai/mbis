package com.hyb.chapter03.section07.module;

import java.util.Date;

public class StudentSelfCard {
    private Integer id;

    private Integer studentId;

    private String cnative;

    private Date issueDate;

    private Date endDate;

    private String note;

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

    public String getCnative() {
        return cnative;
    }

    public void setCnative(String cnative) {
        this.cnative = cnative;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "StudentSelfCard{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", cnative='" + cnative + '\'' +
                ", issueDate=" + issueDate +
                ", endDate=" + endDate +
                ", note='" + note + '\'' +
                '}';
    }
}