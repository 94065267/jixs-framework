package com.jixs.dao.po.db2;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "td_wo_sysconfig")
public class TdWoSysconfig {
    /**
     * 参数编码
     */
    @Id
    @Column(name = "PARA_ID")
    private String paraId;

    /**
     * 参数类别
     */
    @Column(name = "PARA_TYPE")
    private String paraType;

    /**
     * 参数名称
     */
    @Column(name = "PARA_NAME")
    private String paraName;

    /**
     * 参数描述
     */
    @Column(name = "PARA_DESC")
    private String paraDesc;

    /**
     * 参数值
     */
    @Column(name = "PARA_VALUE")
    private String paraValue;

    /**
     * 扩展参数1
     */
    @Column(name = "FST_VALUE")
    private String fstValue;

    /**
     * 扩展参数2
     */
    @Column(name = "SND_VALUE")
    private String sndValue;

    /**
     * 扩展参数值3
     */
    @Column(name = "TRD_VALUE")
    private String trdValue;

    /**
     * 扩展参数4
     */
    @Column(name = "FRTH_VALUE")
    private String frthValue;

    /**
     * 扩展参数5
     */
    @Column(name = "FIFTH_VALUE")
    private String fifthValue;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 状态
     */
    @Column(name = "STS")
    private String sts;

    /**
     * 状态变更时间
     */
    @Column(name = "STS_TIME")
    private Date stsTime;

    /**
     * 修改员工
     */
    @Column(name = "UPDATE_STAFF")
    private String updateStaff;

    /**
     * 租户标识
     */
    @Column(name = "TENANT_ID")
    private String tenantId;

    /**
     * 归属域
     */
    @Column(name = "BELONG")
    private String belong;

    /**
     * 获取参数编码
     *
     * @return PARA_ID - 参数编码
     */
    public String getParaId() {
        return paraId;
    }

    /**
     * 设置参数编码
     *
     * @param paraId 参数编码
     */
    public void setParaId(String paraId) {
        this.paraId = paraId;
    }

    /**
     * 获取参数类别
     *
     * @return PARA_TYPE - 参数类别
     */
    public String getParaType() {
        return paraType;
    }

    /**
     * 设置参数类别
     *
     * @param paraType 参数类别
     */
    public void setParaType(String paraType) {
        this.paraType = paraType;
    }

    /**
     * 获取参数名称
     *
     * @return PARA_NAME - 参数名称
     */
    public String getParaName() {
        return paraName;
    }

    /**
     * 设置参数名称
     *
     * @param paraName 参数名称
     */
    public void setParaName(String paraName) {
        this.paraName = paraName;
    }

    /**
     * 获取参数描述
     *
     * @return PARA_DESC - 参数描述
     */
    public String getParaDesc() {
        return paraDesc;
    }

    /**
     * 设置参数描述
     *
     * @param paraDesc 参数描述
     */
    public void setParaDesc(String paraDesc) {
        this.paraDesc = paraDesc;
    }

    /**
     * 获取参数值
     *
     * @return PARA_VALUE - 参数值
     */
    public String getParaValue() {
        return paraValue;
    }

    /**
     * 设置参数值
     *
     * @param paraValue 参数值
     */
    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }

    /**
     * 获取扩展参数1
     *
     * @return FST_VALUE - 扩展参数1
     */
    public String getFstValue() {
        return fstValue;
    }

    /**
     * 设置扩展参数1
     *
     * @param fstValue 扩展参数1
     */
    public void setFstValue(String fstValue) {
        this.fstValue = fstValue;
    }

    /**
     * 获取扩展参数2
     *
     * @return SND_VALUE - 扩展参数2
     */
    public String getSndValue() {
        return sndValue;
    }

    /**
     * 设置扩展参数2
     *
     * @param sndValue 扩展参数2
     */
    public void setSndValue(String sndValue) {
        this.sndValue = sndValue;
    }

    /**
     * 获取扩展参数值3
     *
     * @return TRD_VALUE - 扩展参数值3
     */
    public String getTrdValue() {
        return trdValue;
    }

    /**
     * 设置扩展参数值3
     *
     * @param trdValue 扩展参数值3
     */
    public void setTrdValue(String trdValue) {
        this.trdValue = trdValue;
    }

    /**
     * 获取扩展参数4
     *
     * @return FRTH_VALUE - 扩展参数4
     */
    public String getFrthValue() {
        return frthValue;
    }

    /**
     * 设置扩展参数4
     *
     * @param frthValue 扩展参数4
     */
    public void setFrthValue(String frthValue) {
        this.frthValue = frthValue;
    }

    /**
     * 获取扩展参数5
     *
     * @return FIFTH_VALUE - 扩展参数5
     */
    public String getFifthValue() {
        return fifthValue;
    }

    /**
     * 设置扩展参数5
     *
     * @param fifthValue 扩展参数5
     */
    public void setFifthValue(String fifthValue) {
        this.fifthValue = fifthValue;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取状态
     *
     * @return STS - 状态
     */
    public String getSts() {
        return sts;
    }

    /**
     * 设置状态
     *
     * @param sts 状态
     */
    public void setSts(String sts) {
        this.sts = sts;
    }

    /**
     * 获取状态变更时间
     *
     * @return STS_TIME - 状态变更时间
     */
    public Date getStsTime() {
        return stsTime;
    }

    /**
     * 设置状态变更时间
     *
     * @param stsTime 状态变更时间
     */
    public void setStsTime(Date stsTime) {
        this.stsTime = stsTime;
    }

    /**
     * 获取修改员工
     *
     * @return UPDATE_STAFF - 修改员工
     */
    public String getUpdateStaff() {
        return updateStaff;
    }

    /**
     * 设置修改员工
     *
     * @param updateStaff 修改员工
     */
    public void setUpdateStaff(String updateStaff) {
        this.updateStaff = updateStaff;
    }

    /**
     * 获取租户标识
     *
     * @return TENANT_ID - 租户标识
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * 设置租户标识
     *
     * @param tenantId 租户标识
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * 获取归属域
     *
     * @return BELONG - 归属域
     */
    public String getBelong() {
        return belong;
    }

    /**
     * 设置归属域
     *
     * @param belong 归属域
     */
    public void setBelong(String belong) {
        this.belong = belong;
    }
}
