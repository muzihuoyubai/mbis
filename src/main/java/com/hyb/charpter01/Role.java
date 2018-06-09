package com.hyb.charpter01;

/**
 * 2018/6/6 06 06 2018
 */
public class Role {
    private Long id;
    private String roleName;
    private String note;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
