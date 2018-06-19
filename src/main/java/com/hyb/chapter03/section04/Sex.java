package com.hyb.chapter03.section04;

/**
 * typeHandler处理枚举
 *
 * @author HYB
 * @since 2018/6/18 15:28
 **/
public enum Sex {
    MALE(1, "男"),
    FEMALE(2, "女"),
    UNKNOWN(99, "未知");
    private int id;
    private String name;

    Sex(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Sex parse(int id) {
        for (Sex one : Sex.values()) {
            if (one.getId() == id) {
                return one;
            }
        }
        return UNKNOWN;
    }

    public static Sex parse(String name) {
        for (Sex one : Sex.values()) {
            if (one.getName().equals(name)) {
                return one;
            }
        }
        return UNKNOWN;
    }

}
