package com.jixs.tkmybatis.po;

import com.jixs.tkmybatis.tools.DynamicTableName;
import tk.mybatis.mapper.entity.IDynamicTableName;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tf_so_order")
public class TfSoOrder extends DynamicTableName {
    /**
     * 定单号码
     */
    @Id
    @Column(name = "ORD_ID")
    private String ordId;

    /**
     * 业务号码
     */
    @Column(name = "ACC_NBR")
    private String accNbr;

    /**
     * 本地网
     */
    @Column(name = "LOCAL_NET_ID")
    private String localNetId;

    /**
     * 区县
     */
    @Column(name = "AREA_ID")
    private String areaId;

    /**
     * 局向
     */
    @Column(name = "BRANCH_NO")
    private String branchNo;

    /**
     * 原局向
     */
    @Column(name = "O_BRANCH_NO")
    private String oBranchNo;

    /**
     * 产品标识
     */
    @Column(name = "ORDAI_PROD_ID")
    private String ordaiProdId;

    /**
     * 原产品标识
     */
    @Column(name = "O_PROD_ID")
    private String oProdId;

    /**
     * 主动作
     */
    @Column(name = "ACTION_ID")
    private String actionId;

    /**
     * 用户标识
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 定单类型
     */
    @Column(name = "ORD_TYPE")
    private String ordType;

    /**
     * 流程启动方式，长流程短流程标志（L--长流程，S---短流程）
     */
    @Column(name = "PRO_STARTMODE")
    private String proStartmode;

    /**
     * 电信类型：0-固网 1-G网
     */
    @Column(name = "NET_TYPE")
    private String netType;

    /**
     * 外部定单号
     */
    @Column(name = "EXT_ORD_ID")
    private String extOrdId;

    /**
     * 受理时间
     */
    @Column(name = "ACCEPT_TIME")
    private Date acceptTime;

    /**
     * 证件编码
     */
    @Column(name = "ICCID")
    private String iccid;

    /**
     * 定单优先级
     */
    @Column(name = "PRIORITY")
    private String priority;

    /**
     * 消息ID
     */
    @Column(name = "MESSAGE_ID")
    private String messageId;

    /**
     * 定单模板
     */
    @Column(name = "ORDT_ID")
    private String ordtId;

    /**
     * 流程实例标识
     */
    @Column(name = "PROINS_ID")
    private String proinsId;

    /**
     * 定单群组标识
     */
    @Column(name = "ORD_GROUP_ID")
    private String ordGroupId;

    /**
     * 定单状态
     */
    @Column(name = "ORD_STS")
    private String ordSts;

    /**
     * 定单状态时间
     */
    @Column(name = "ORD_STS_TIME")
    private Date ordStsTime;

    /**
     * 定单创建时间
     */
    @Column(name = "ORD_CREATE_TIME")
    private Date ordCreateTime;

    /**
     * 备注
     */
    @Column(name = "NOTES")
    private String notes;

    /**
     * 网别
     */
    @Column(name = "NET_CODE")
    private String netCode;

    /**
     * 原网别
     */
    @Column(name = "O_NET_CODE")
    private String oNetCode;

    /**
     * 原业务号码
     */
    @Column(name = "O_ACC_NBR")
    private String oAccNbr;

    /**
     * 省分标识
     */
    @Column(name = "PROVINCE_ID")
    private String provinceId;

    /**
     * 分库标识
     */
    @Column(name = "PARTITION_NO")
    private Long partitionNo;

    /**
     * 租户标识
     */
    @Column(name = "TENANT_ID")
    private String tenantId;

    /**
     * 分表标识
     */
    @Column(name = "SAVE_CODE")
    private String saveCode;

    /**
     * 获取定单号码
     *
     * @return ORD_ID - 定单号码
     */
    public String getOrdId() {
        return ordId;
    }

    /**
     * 设置定单号码
     *
     * @param ordId 定单号码
     */
    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    /**
     * 获取业务号码
     *
     * @return ACC_NBR - 业务号码
     */
    public String getAccNbr() {
        return accNbr;
    }

    /**
     * 设置业务号码
     *
     * @param accNbr 业务号码
     */
    public void setAccNbr(String accNbr) {
        this.accNbr = accNbr;
    }

    /**
     * 获取本地网
     *
     * @return LOCAL_NET_ID - 本地网
     */
    public String getLocalNetId() {
        return localNetId;
    }

    /**
     * 设置本地网
     *
     * @param localNetId 本地网
     */
    public void setLocalNetId(String localNetId) {
        this.localNetId = localNetId;
    }

    /**
     * 获取区县
     *
     * @return AREA_ID - 区县
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 设置区县
     *
     * @param areaId 区县
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取局向
     *
     * @return BRANCH_NO - 局向
     */
    public String getBranchNo() {
        return branchNo;
    }

    /**
     * 设置局向
     *
     * @param branchNo 局向
     */
    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    /**
     * 获取原局向
     *
     * @return O_BRANCH_NO - 原局向
     */
    public String getoBranchNo() {
        return oBranchNo;
    }

    /**
     * 设置原局向
     *
     * @param oBranchNo 原局向
     */
    public void setoBranchNo(String oBranchNo) {
        this.oBranchNo = oBranchNo;
    }

    /**
     * 获取产品标识
     *
     * @return ORDAI_PROD_ID - 产品标识
     */
    public String getOrdaiProdId() {
        return ordaiProdId;
    }

    /**
     * 设置产品标识
     *
     * @param ordaiProdId 产品标识
     */
    public void setOrdaiProdId(String ordaiProdId) {
        this.ordaiProdId = ordaiProdId;
    }

    /**
     * 获取原产品标识
     *
     * @return O_PROD_ID - 原产品标识
     */
    public String getoProdId() {
        return oProdId;
    }

    /**
     * 设置原产品标识
     *
     * @param oProdId 原产品标识
     */
    public void setoProdId(String oProdId) {
        this.oProdId = oProdId;
    }

    /**
     * 获取主动作
     *
     * @return ACTION_ID - 主动作
     */
    public String getActionId() {
        return actionId;
    }

    /**
     * 设置主动作
     *
     * @param actionId 主动作
     */
    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    /**
     * 获取用户标识
     *
     * @return USER_ID - 用户标识
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户标识
     *
     * @param userId 用户标识
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取定单类型
     *
     * @return ORD_TYPE - 定单类型
     */
    public String getOrdType() {
        return ordType;
    }

    /**
     * 设置定单类型
     *
     * @param ordType 定单类型
     */
    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }

    /**
     * 获取流程启动方式，长流程短流程标志（L--长流程，S---短流程）
     *
     * @return PRO_STARTMODE - 流程启动方式，长流程短流程标志（L--长流程，S---短流程）
     */
    public String getProStartmode() {
        return proStartmode;
    }

    /**
     * 设置流程启动方式，长流程短流程标志（L--长流程，S---短流程）
     *
     * @param proStartmode 流程启动方式，长流程短流程标志（L--长流程，S---短流程）
     */
    public void setProStartmode(String proStartmode) {
        this.proStartmode = proStartmode;
    }

    /**
     * 获取电信类型：0-固网 1-G网
     *
     * @return NET_TYPE - 电信类型：0-固网 1-G网
     */
    public String getNetType() {
        return netType;
    }

    /**
     * 设置电信类型：0-固网 1-G网
     *
     * @param netType 电信类型：0-固网 1-G网
     */
    public void setNetType(String netType) {
        this.netType = netType;
    }

    /**
     * 获取外部定单号
     *
     * @return EXT_ORD_ID - 外部定单号
     */
    public String getExtOrdId() {
        return extOrdId;
    }

    /**
     * 设置外部定单号
     *
     * @param extOrdId 外部定单号
     */
    public void setExtOrdId(String extOrdId) {
        this.extOrdId = extOrdId;
    }

    /**
     * 获取受理时间
     *
     * @return ACCEPT_TIME - 受理时间
     */
    public Date getAcceptTime() {
        return acceptTime;
    }

    /**
     * 设置受理时间
     *
     * @param acceptTime 受理时间
     */
    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    /**
     * 获取证件编码
     *
     * @return ICCID - 证件编码
     */
    public String getIccid() {
        return iccid;
    }

    /**
     * 设置证件编码
     *
     * @param iccid 证件编码
     */
    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    /**
     * 获取定单优先级
     *
     * @return PRIORITY - 定单优先级
     */
    public String getPriority() {
        return priority;
    }

    /**
     * 设置定单优先级
     *
     * @param priority 定单优先级
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * 获取消息ID
     *
     * @return MESSAGE_ID - 消息ID
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 设置消息ID
     *
     * @param messageId 消息ID
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * 获取定单模板
     *
     * @return ORDT_ID - 定单模板
     */
    public String getOrdtId() {
        return ordtId;
    }

    /**
     * 设置定单模板
     *
     * @param ordtId 定单模板
     */
    public void setOrdtId(String ordtId) {
        this.ordtId = ordtId;
    }

    /**
     * 获取流程实例标识
     *
     * @return PROINS_ID - 流程实例标识
     */
    public String getProinsId() {
        return proinsId;
    }

    /**
     * 设置流程实例标识
     *
     * @param proinsId 流程实例标识
     */
    public void setProinsId(String proinsId) {
        this.proinsId = proinsId;
    }

    /**
     * 获取定单群组标识
     *
     * @return ORD_GROUP_ID - 定单群组标识
     */
    public String getOrdGroupId() {
        return ordGroupId;
    }

    /**
     * 设置定单群组标识
     *
     * @param ordGroupId 定单群组标识
     */
    public void setOrdGroupId(String ordGroupId) {
        this.ordGroupId = ordGroupId;
    }

    /**
     * 获取定单状态
     *
     * @return ORD_STS - 定单状态
     */
    public String getOrdSts() {
        return ordSts;
    }

    /**
     * 设置定单状态
     *
     * @param ordSts 定单状态
     */
    public void setOrdSts(String ordSts) {
        this.ordSts = ordSts;
    }

    /**
     * 获取定单状态时间
     *
     * @return ORD_STS_TIME - 定单状态时间
     */
    public Date getOrdStsTime() {
        return ordStsTime;
    }

    /**
     * 设置定单状态时间
     *
     * @param ordStsTime 定单状态时间
     */
    public void setOrdStsTime(Date ordStsTime) {
        this.ordStsTime = ordStsTime;
    }

    /**
     * 获取定单创建时间
     *
     * @return ORD_CREATE_TIME - 定单创建时间
     */
    public Date getOrdCreateTime() {
        return ordCreateTime;
    }

    /**
     * 设置定单创建时间
     *
     * @param ordCreateTime 定单创建时间
     */
    public void setOrdCreateTime(Date ordCreateTime) {
        this.ordCreateTime = ordCreateTime;
    }

    /**
     * 获取备注
     *
     * @return NOTES - 备注
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置备注
     *
     * @param notes 备注
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * 获取网别
     *
     * @return NET_CODE - 网别
     */
    public String getNetCode() {
        return netCode;
    }

    /**
     * 设置网别
     *
     * @param netCode 网别
     */
    public void setNetCode(String netCode) {
        this.netCode = netCode;
    }

    /**
     * 获取原网别
     *
     * @return O_NET_CODE - 原网别
     */
    public String getoNetCode() {
        return oNetCode;
    }

    /**
     * 设置原网别
     *
     * @param oNetCode 原网别
     */
    public void setoNetCode(String oNetCode) {
        this.oNetCode = oNetCode;
    }

    /**
     * 获取原业务号码
     *
     * @return O_ACC_NBR - 原业务号码
     */
    public String getoAccNbr() {
        return oAccNbr;
    }

    /**
     * 设置原业务号码
     *
     * @param oAccNbr 原业务号码
     */
    public void setoAccNbr(String oAccNbr) {
        this.oAccNbr = oAccNbr;
    }

    /**
     * 获取省分标识
     *
     * @return PROVINCE_ID - 省分标识
     */
    public String getProvinceId() {
        return provinceId;
    }

    /**
     * 设置省分标识
     *
     * @param provinceId 省分标识
     */
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取分库标识
     *
     * @return PARTITION_NO - 分库标识
     */
    public Long getPartitionNo() {
        return partitionNo;
    }

    /**
     * 设置分库标识
     *
     * @param partitionNo 分库标识
     */
    public void setPartitionNo(Long partitionNo) {
        this.partitionNo = partitionNo;
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
     * 获取分表标识
     *
     * @return SAVE_CODE - 分表标识
     */
    public String getSaveCode() {
        return saveCode;
    }

    /**
     * 设置分表标识
     *
     * @param saveCode 分表标识
     */
    public void setSaveCode(String saveCode) {
        this.saveCode = saveCode;
    }
}