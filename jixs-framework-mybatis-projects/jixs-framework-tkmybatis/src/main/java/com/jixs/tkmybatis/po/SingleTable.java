package com.jixs.tkmybatis.po;

import javax.persistence.*;

@Table(name = "single_table2")
public class SingleTable {
    @Id
    private Integer id;

    private String key1;

    private Integer key2;

    private String key3;

    @Column(name = "key_part1")
    private String keyPart1;

    @Column(name = "key_part2")
    private String keyPart2;

    @Column(name = "key_part3")
    private String keyPart3;

    @Column(name = "common_field")
    private String commonField;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return key1
     */
    public String getKey1() {
        return key1;
    }

    /**
     * @param key1
     */
    public void setKey1(String key1) {
        this.key1 = key1;
    }

    /**
     * @return key2
     */
    public Integer getKey2() {
        return key2;
    }

    /**
     * @param key2
     */
    public void setKey2(Integer key2) {
        this.key2 = key2;
    }

    /**
     * @return key3
     */
    public String getKey3() {
        return key3;
    }

    /**
     * @param key3
     */
    public void setKey3(String key3) {
        this.key3 = key3;
    }

    /**
     * @return key_part1
     */
    public String getKeyPart1() {
        return keyPart1;
    }

    /**
     * @param keyPart1
     */
    public void setKeyPart1(String keyPart1) {
        this.keyPart1 = keyPart1;
    }

    /**
     * @return key_part2
     */
    public String getKeyPart2() {
        return keyPart2;
    }

    /**
     * @param keyPart2
     */
    public void setKeyPart2(String keyPart2) {
        this.keyPart2 = keyPart2;
    }

    /**
     * @return key_part3
     */
    public String getKeyPart3() {
        return keyPart3;
    }

    /**
     * @param keyPart3
     */
    public void setKeyPart3(String keyPart3) {
        this.keyPart3 = keyPart3;
    }

    /**
     * @return common_field
     */
    public String getCommonField() {
        return commonField;
    }

    /**
     * @param commonField
     */
    public void setCommonField(String commonField) {
        this.commonField = commonField;
    }
}