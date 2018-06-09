package com.hyb.chapter01;

import java.util.Objects;

/**
 * 增删改查demo
 *
 * @author HYB
 * @since 2018/6/9 15:02
 **/
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(note, role.note);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, roleName, note);
    }
}
