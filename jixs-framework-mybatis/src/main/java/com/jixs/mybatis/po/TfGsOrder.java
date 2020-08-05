package com.jixs.mybatis.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TfGsOrder implements Serializable {
    /**
     * 保障单编号
     */
    private String ordId;

    /**
     * 流程实例标识
     */
    private String proinsId;

    /**
     * 外部系统编号:recSeq
     */
    private String extOrdId;

    /**
     * 保障单类型
     */
    private String gsType;

    /**
     * 保障单优先级：complainLevel
     */
    private String gsPri;

    /**
     * 受理省
     */
    private String provinceId;

    /**
     * 受理地市
     */
    private String cityId;

    /**
     * 受理区域
     */
    private String areaId;

    /**
     * 受理来源:客服:order_source_csp
     */
    private String ordSource;

    /**
     * 受理时间
     */
    private Date acceptTime;

    private String acceptStaffId;

    /**
     * 受理员工名称
     */
    private String acceptStaffName;

    /**
     * 受理渠道
     */
    private String acceptDepartId;

    /**
     * 受理渠道名称
     */
    private String acceptDepartName;

    /**
     * 受理员工电话
     */
    private String acceptPhone;

    /**
     * 保障单状态
     */
    private String sts;

    /**
     * 上一个状态
     */
    private String oldSts;

    /**
     * 是否故障：1、是, 0、否
     */
    private Integer isFault;

    /**
     * 是否重大障碍：1、是, 0、否
     */
    private Integer isMajorFault;

    /**
     * 是否群障：1、是, 0、否
     */
    private Integer isGroupFault;

    /**
     * 默认0
     */
    private Integer repeatApplyNum;

    /**
     * 默认0
     */
    private Integer repeatFaultNum;

    /**
     * 重派标识：1、是, 0、否
     */
    private Integer redispatchFlag;

    /**
     * 状态更新时间
     */
    private Date stsTime;

    /**
     * 竣工时间
     */
    private Date finishTime;

    /**
     * 预警时间
     */
    private Date alertTime;

    /**
     * 告警时间
     */
    private Date warnTime;

    /**
     * 超时时间
     */
    private Date overTime;

    /**
     * 要求解决时间
     */
    private Date limitTime;

    /**
     * 是否预约：1、是, 0、否
     */
    private Integer isReservat;

    /**
     * 预约时间
     */
    private Date reservatTime;

    /**
     * 备注
     */
    private String note;

    /**
     * 服务号码，如：宽带账号
     */
    private String serviceNum;

    /**
     * 派单时间
     */
    private Date sendTime;

    /**
     * 租户标识
     */
    private String tenantId;

    /**
     * 催单次数
     */
    private Integer reminderNum;

    /**
     * 定单属性
     */
    private List<TfGsAttr> orderAttrs;

    /**
     * 获取保障单编号
     *
     * @return ORD_ID - 保障单编号
     */
    public String getOrdId() {
        return ordId;
    }

    /**
     * 设置保障单编号
     *
     * @param ordId 保障单编号
     */
    public void setOrdId(String ordId) {
        this.ordId = ordId;
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
     * 获取外部系统编号:recSeq
     *
     * @return EXT_ORD_ID - 外部系统编号:recSeq
     */
    public String getExtOrdId() {
        return extOrdId;
    }

    /**
     * 设置外部系统编号:recSeq
     *
     * @param extOrdId 外部系统编号:recSeq
     */
    public void setExtOrdId(String extOrdId) {
        this.extOrdId = extOrdId;
    }

    /**
     * 获取保障单类型
     *
     * @return GS_TYPE - 保障单类型
     */
    public String getGsType() {
        return gsType;
    }

    /**
     * 设置保障单类型
     *
     * @param gsType 保障单类型
     */
    public void setGsType(String gsType) {
        this.gsType = gsType;
    }

    /**
     * 获取保障单优先级：complainLevel
     *
     * @return GS_PRI - 保障单优先级：complainLevel
     */
    public String getGsPri() {
        return gsPri;
    }

    /**
     * 设置保障单优先级：complainLevel
     *
     * @param gsPri 保障单优先级：complainLevel
     */
    public void setGsPri(String gsPri) {
        this.gsPri = gsPri;
    }

    /**
     * 获取受理省
     *
     * @return PROVINCE_ID - 受理省
     */
    public String getProvinceId() {
        return provinceId;
    }

    /**
     * 设置受理省
     *
     * @param provinceId 受理省
     */
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取受理地市
     *
     * @return CITY_ID - 受理地市
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * 设置受理地市
     *
     * @param cityId 受理地市
     */
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取受理区域
     *
     * @return AREA_ID - 受理区域
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 设置受理区域
     *
     * @param areaId 受理区域
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取受理来源:客服:order_source_csp
     *
     * @return ORD_SOURCE - 受理来源:客服:order_source_csp
     */
    public String getOrdSource() {
        return ordSource;
    }

    /**
     * 设置受理来源:客服:order_source_csp
     *
     * @param ordSource 受理来源:客服:order_source_csp
     */
    public void setOrdSource(String ordSource) {
        this.ordSource = ordSource;
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
     * @return ACCEPT_STAFF_ID
     */
    public String getAcceptStaffId() {
        return acceptStaffId;
    }

    /**
     * @param acceptStaffId
     */
    public void setAcceptStaffId(String acceptStaffId) {
        this.acceptStaffId = acceptStaffId;
    }

    /**
     * 获取受理员工名称
     *
     * @return ACCEPT_STAFF_NAME - 受理员工名称
     */
    public String getAcceptStaffName() {
        return acceptStaffName;
    }

    /**
     * 设置受理员工名称
     *
     * @param acceptStaffName 受理员工名称
     */
    public void setAcceptStaffName(String acceptStaffName) {
        this.acceptStaffName = acceptStaffName;
    }

    /**
     * 获取受理渠道
     *
     * @return ACCEPT_DEPART_ID - 受理渠道
     */
    public String getAcceptDepartId() {
        return acceptDepartId;
    }

    /**
     * 设置受理渠道
     *
     * @param acceptDepartId 受理渠道
     */
    public void setAcceptDepartId(String acceptDepartId) {
        this.acceptDepartId = acceptDepartId;
    }

    /**
     * 获取受理渠道名称
     *
     * @return ACCEPT_DEPART_NAME - 受理渠道名称
     */
    public String getAcceptDepartName() {
        return acceptDepartName;
    }

    /**
     * 设置受理渠道名称
     *
     * @param acceptDepartName 受理渠道名称
     */
    public void setAcceptDepartName(String acceptDepartName) {
        this.acceptDepartName = acceptDepartName;
    }

    /**
     * 获取受理员工电话
     *
     * @return ACCEPT_PHONE - 受理员工电话
     */
    public String getAcceptPhone() {
        return acceptPhone;
    }

    /**
     * 设置受理员工电话
     *
     * @param acceptPhone 受理员工电话
     */
    public void setAcceptPhone(String acceptPhone) {
        this.acceptPhone = acceptPhone;
    }

    /**
     * 获取保障单状态
     *
     * @return STS - 保障单状态
     */
    public String getSts() {
        return sts;
    }

    /**
     * 设置保障单状态
     *
     * @param sts 保障单状态
     */
    public void setSts(String sts) {
        this.sts = sts;
    }

    /**
     * 获取上一个状态
     *
     * @return OLD_STS - 上一个状态
     */
    public String getOldSts() {
        return oldSts;
    }

    /**
     * 设置上一个状态
     *
     * @param oldSts 上一个状态
     */
    public void setOldSts(String oldSts) {
        this.oldSts = oldSts;
    }

    /**
     * 获取是否故障：1、是, 0、否
     *
     * @return IS_FAULT - 是否故障：1、是, 0、否
     */
    public Integer getIsFault() {
        return isFault;
    }

    /**
     * 设置是否故障：1、是, 0、否
     *
     * @param isFault 是否故障：1、是, 0、否
     */
    public void setIsFault(Integer isFault) {
        this.isFault = isFault;
    }

    /**
     * 获取是否重大障碍：1、是, 0、否
     *
     * @return IS_MAJOR_FAULT - 是否重大障碍：1、是, 0、否
     */
    public Integer getIsMajorFault() {
        return isMajorFault;
    }

    /**
     * 设置是否重大障碍：1、是, 0、否
     *
     * @param isMajorFault 是否重大障碍：1、是, 0、否
     */
    public void setIsMajorFault(Integer isMajorFault) {
        this.isMajorFault = isMajorFault;
    }

    /**
     * 获取是否群障：1、是, 0、否
     *
     * @return IS_GROUP_FAULT - 是否群障：1、是, 0、否
     */
    public Integer getIsGroupFault() {
        return isGroupFault;
    }

    /**
     * 设置是否群障：1、是, 0、否
     *
     * @param isGroupFault 是否群障：1、是, 0、否
     */
    public void setIsGroupFault(Integer isGroupFault) {
        this.isGroupFault = isGroupFault;
    }

    /**
     * 获取默认0
     *
     * @return REPEAT_APPLY_NUM - 默认0
     */
    public Integer getRepeatApplyNum() {
        return repeatApplyNum;
    }

    /**
     * 设置默认0
     *
     * @param repeatApplyNum 默认0
     */
    public void setRepeatApplyNum(Integer repeatApplyNum) {
        this.repeatApplyNum = repeatApplyNum;
    }

    /**
     * 获取默认0
     *
     * @return REPEAT_FAULT_NUM - 默认0
     */
    public Integer getRepeatFaultNum() {
        return repeatFaultNum;
    }

    /**
     * 设置默认0
     *
     * @param repeatFaultNum 默认0
     */
    public void setRepeatFaultNum(Integer repeatFaultNum) {
        this.repeatFaultNum = repeatFaultNum;
    }

    /**
     * 获取重派标识：1、是, 0、否
     *
     * @return REDISPATCH_FLAG - 重派标识：1、是, 0、否
     */
    public Integer getRedispatchFlag() {
        return redispatchFlag;
    }

    /**
     * 设置重派标识：1、是, 0、否
     *
     * @param redispatchFlag 重派标识：1、是, 0、否
     */
    public void setRedispatchFlag(Integer redispatchFlag) {
        this.redispatchFlag = redispatchFlag;
    }

    /**
     * 获取状态更新时间
     *
     * @return STS_TIME - 状态更新时间
     */
    public Date getStsTime() {
        return stsTime;
    }

    /**
     * 设置状态更新时间
     *
     * @param stsTime 状态更新时间
     */
    public void setStsTime(Date stsTime) {
        this.stsTime = stsTime;
    }

    /**
     * 获取竣工时间
     *
     * @return FINISH_TIME - 竣工时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置竣工时间
     *
     * @param finishTime 竣工时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取预警时间
     *
     * @return ALERT_TIME - 预警时间
     */
    public Date getAlertTime() {
        return alertTime;
    }

    /**
     * 设置预警时间
     *
     * @param alertTime 预警时间
     */
    public void setAlertTime(Date alertTime) {
        this.alertTime = alertTime;
    }

    /**
     * 获取告警时间
     *
     * @return WARN_TIME - 告警时间
     */
    public Date getWarnTime() {
        return warnTime;
    }

    /**
     * 设置告警时间
     *
     * @param warnTime 告警时间
     */
    public void setWarnTime(Date warnTime) {
        this.warnTime = warnTime;
    }

    /**
     * 获取超时时间
     *
     * @return OVER_TIME - 超时时间
     */
    public Date getOverTime() {
        return overTime;
    }

    /**
     * 设置超时时间
     *
     * @param overTime 超时时间
     */
    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    /**
     * 获取要求解决时间
     *
     * @return LIMIT_TIME - 要求解决时间
     */
    public Date getLimitTime() {
        return limitTime;
    }

    /**
     * 设置要求解决时间
     *
     * @param limitTime 要求解决时间
     */
    public void setLimitTime(Date limitTime) {
        this.limitTime = limitTime;
    }

    /**
     * 获取是否预约：1、是, 0、否
     *
     * @return IS_RESERVAT - 是否预约：1、是, 0、否
     */
    public Integer getIsReservat() {
        return isReservat;
    }

    /**
     * 设置是否预约：1、是, 0、否
     *
     * @param isReservat 是否预约：1、是, 0、否
     */
    public void setIsReservat(Integer isReservat) {
        this.isReservat = isReservat;
    }

    /**
     * 获取预约时间
     *
     * @return RESERVAT_TIME - 预约时间
     */
    public Date getReservatTime() {
        return reservatTime;
    }

    /**
     * 设置预约时间
     *
     * @param reservatTime 预约时间
     */
    public void setReservatTime(Date reservatTime) {
        this.reservatTime = reservatTime;
    }

    /**
     * 获取备注
     *
     * @return NOTE - 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 获取服务号码，如：宽带账号
     *
     * @return SERVICE_NUM - 服务号码，如：宽带账号
     */
    public String getServiceNum() {
        return serviceNum;
    }

    /**
     * 设置服务号码，如：宽带账号
     *
     * @param serviceNum 服务号码，如：宽带账号
     */
    public void setServiceNum(String serviceNum) {
        this.serviceNum = serviceNum;
    }

    /**
     * 获取派单时间
     *
     * @return SEND_TIME - 派单时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 设置派单时间
     *
     * @param sendTime 派单时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
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
     * 获取催单次数
     *
     * @return REMINDER_NUM - 催单次数
     */
    public Integer getReminderNum() {
        return reminderNum;
    }

    /**
     * 设置催单次数
     *
     * @param reminderNum 催单次数
     */
    public void setReminderNum(Integer reminderNum) {
        this.reminderNum = reminderNum;
    }

    public List<TfGsAttr> getOrderAttrs() {
        return orderAttrs;
    }

    public void setOrderAttrs(List<TfGsAttr> orderAttrs) {
        this.orderAttrs = orderAttrs;
    }
}