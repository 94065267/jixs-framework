package com.jixs.common;

public enum TimeEnum {
    /**
     *
     */
    AM("am", "上午") {
        @Override
        public void setCity(String code, String name) {
        }
    },
    PM("pm", "下午") {
        @Override
        public void setCity(String code, String name) {
        }
    },
    DAY("day", "全天") {
        @Override
        public void setCity(String code, String name) {
        }
    },
    HOUR("hour", "小时") {
        @Override
        public void setCity(String code, String name) {
        }
    };

    public abstract void setCity(String code, String name);

    private String code;
    private String name;

    TimeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
