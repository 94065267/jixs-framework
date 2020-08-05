package com.jixs.tkmybatis.po;

import javax.persistence.*;

@Table(name = "test_gis_sharding")
public class TestGisSharding {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SHARDING_ID")
    private Integer shardingId;

    @Column(name = "GEOMETRY")
    private byte[] geometry;

    /**
     * @return ID
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
     * @return CODE
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return SHARDING_ID
     */
    public Integer getShardingId() {
        return shardingId;
    }

    /**
     * @param shardingId
     */
    public void setShardingId(Integer shardingId) {
        this.shardingId = shardingId;
    }

    /**
     * @return GEOMETRY
     */
    public byte[] getGeometry() {
        return geometry;
    }

    /**
     * @param geometry
     */
    public void setGeometry(byte[] geometry) {
        this.geometry = geometry;
    }
}