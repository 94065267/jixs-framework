package com.jixs.mybatis.typehandler;

/**
 * 性别枚举类
 *
 * @author jixs
 */
public enum SexEnum implements BaseEnum {
    /**
     * 性别
     */
    FEMALE(0, "女"), MALE(1, "男"), UNKNOWN(-1, "未知");

    private int id;
    private String name;

    SexEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
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

    public static SexEnum getSexEnumById(int id) {
        if (id == 0) {
            return FEMALE;
        } else if (id == 1) {
            return MALE;
        } else {
            return UNKNOWN;
        }
    }
}
