package com.hyb.chapter03.section04;

import java.util.Objects;

/**
 * 枚举的typeHandler实体类
 *
 * @author HYB
 * @since 2018/6/9 15:02
 **/
public class User {
    private Long id;
    private String roleName;
    private String note;
    private Sex sex;

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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(roleName, user.roleName) &&
                Objects.equals(note, user.note) &&
                sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, note, sex);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                ", sex=" + sex +
                '}';
    }
}
