package com.sitech.iom;

import com.sitech.iom.wo.dao.mapper.TdWoCmddisruleMapper;
import com.sitech.iom.wo.dao.mapper.TdWoCmdparamMapper;
import com.sitech.iom.wo.dao.po.TdWoCmddisrule;
import com.sitech.iom.wo.dao.po.TdWoCmdparam;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 说明：文件说明
 *
 * @author jixs_bj
 * @date 2023/8/14 10:02
 */

@Slf4j
@Component
public class Instruction {
    @Resource
    private TdWoCmddisruleMapper tdWoCmddisruleMapper;
    @Resource
    private TdWoCmdparamMapper tdWoCmdparamMapper;

    /**
     * @param excelFilePath      excel文件
     * @param sheetName          sheet名称
     * @param cmdDisRuleIdPreFix 主键前缀
     * @param subActionIds       需要处理的附加动作集合
     */
    public void addSubProd(String excelFilePath, String sheetName, String cmdDisRuleIdPreFix, String cmdParamCodePreFix, List<String> subActionIds, String cmdPriority) {
        // 读取excel
        Sheet sheet = this.readSheet(excelFilePath, sheetName);
        if (sheet == null) {
            log.error("excel文件{}没有获取到sheet页【{}】：", excelFilePath, sheetName);
            return;
        }
        String mainProdId = sheetName.split("_")[0];
        String mainActionId = sheetName.split("_")[1];
        log.info("主服务：{}，主动作：{}", mainProdId, mainActionId);
        log.info("最后一行的编号：{}", sheet.getLastRowNum());
        int countRule = 1;
        int countParam = 1;
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            // 循环读取每一个格
            Row row = sheet.getRow(i);
            if (row == null || row.getCell(0) == null || StringUtils.isEmpty(row.getCell(0).getStringCellValue())) {
                continue;
            }
            List<TdWoCmddisrule> cmddisruleList = new ArrayList<>();
            List<TdWoCmdparam> allParams = new ArrayList<>();
            if ("是".equals(row.getCell(2).getStringCellValue())) {
                String subProdId = row.getCell(0).getStringCellValue();
                for (String subActionId : subActionIds) {
                    String cmdDisRuleId = cmdDisRuleIdPreFix + String.format("%03d", countRule++) + subActionId;
                    String cmdParamCode = cmdParamCodePreFix + String.format("%03d", countParam++) + subActionId;
                    TdWoCmddisrule cmddisrule = null;
                    List<TdWoCmdparam> params = null;
                    if ("A".equals(subActionId)) {
                        String cmdId = subProdId + "_1";
                        String paramStr = row.getCell(3).getStringCellValue();
                        cmddisrule = this.getCmddisrule(cmdDisRuleId, mainProdId, mainActionId, subProdId, subActionId, cmdParamCode, cmdId, cmdPriority);
                        params = this.getParams(cmdParamCode, paramStr);
                    }
                    if ("R".equals(subActionId)) {
                        String cmdId = subProdId + "_0";
                        String paramStr = row.getCell(4).getStringCellValue();
                        if (StringUtils.isEmpty(paramStr)) {
                            paramStr = row.getCell(3).getStringCellValue();
                        }
                        cmddisrule = this.getCmddisrule(cmdDisRuleId, mainProdId, mainActionId, subProdId, subActionId, cmdParamCode, cmdId, cmdPriority);
                        params = this.getParams(cmdParamCode, paramStr);
                    }
                    if (cmddisrule != null) {
                        cmddisruleList.add(cmddisrule);
                    }
                    if (!CollectionUtils.isEmpty(params)) {
                        allParams.addAll(params);
                    }
                }
            }
            if (!CollectionUtils.isEmpty(cmddisruleList)) {
                tdWoCmddisruleMapper.insertList(cmddisruleList);
            }
            if (!CollectionUtils.isEmpty(allParams)) {
                tdWoCmdparamMapper.insertList(allParams);
            }
        }
    }

    public Sheet readSheet(String filePath, String sheetName) {
        // 读取excel
        InputStream inputStream = null;
        try {
            inputStream = Files.newInputStream(Paths.get(filePath));
        } catch (IOException e) {
            log.error("{}文件没有找到: ", filePath, e);
            return null;
        }
        Workbook workbook = null;
        try {
            if (filePath.endsWith(".xls")) {
                workbook = new HSSFWorkbook(inputStream);
            } else if (filePath.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            }
        } catch (IOException e) {
            log.error("excel文件:{}读取报错：", filePath, e);
            return null;
        }
        if (workbook == null) {
            log.error("excel文件:{}读取失败", filePath);
            return null;
        }
        return workbook.getSheet(sheetName);
    }

    private TdWoCmddisrule getCmddisrule(String cmdRuleId, String mainProdId, String mainActionId, String subProdId, String subActionId, String cmdParamCode, String cmdId, String cmdPriority) {
        TdWoCmddisrule cmddisrule = new TdWoCmddisrule();
        cmddisrule.setCmdRuleId(cmdRuleId);
        cmddisrule.setLocalNetId("0");
        cmddisrule.setParaType("02");
        cmddisrule.setMainProdId(mainProdId);
        cmddisrule.setMainActionId(mainActionId);
        cmddisrule.setOrdaiProdId(subProdId);
        cmddisrule.setActionId(subActionId);
        cmddisrule.setNeType("0");
        cmddisrule.setDpFlag("0");
        cmddisrule.setCmdCode(cmdParamCode);
        cmddisrule.setProdIdGroup(mainProdId);
        cmddisrule.setDealFlag("0");
        cmddisrule.setProsId("0");
        cmddisrule.setCmdPriority(cmdPriority);
        cmddisrule.setState("1");
        cmddisrule.setCmdId(cmdId);
        cmddisrule.setCreateStaffId("自动导入");
        cmddisrule.setCreateTime(new Date());
        cmddisrule.setTenantId("HK");
        return cmddisrule;
    }

    /**
     * @param cmdParamCode 参数组
     * @param paramStr     参数串 用 | 分割
     * @return 参数列表
     */
    private List<TdWoCmdparam> getParams(String cmdParamCode, String paramStr) {
        if (StringUtils.isEmpty(paramStr)) {
            log.error("参数串不能为空");
            return null;
        }
        List<TdWoCmdparam> list = new ArrayList<>();
        String[] params = paramStr.split("\\|");
        Set<String> set = Arrays.stream(params).collect(Collectors.toSet());
        for (String temp : set) {
            TdWoCmdparam param = new TdWoCmdparam();
            param.setCmdCode(cmdParamCode);
            param.setCmdParam(temp.trim());
            param.setState("1");
            param.setCmdParamSource(temp.trim());
            param.setCmdParamType("0");
            param.setCreateStaffId("自动导入");
            param.setCreateTime(new Date());
            param.setTenantId("HK");
            list.add(param);
        }
        return list;
    }

    public void addMainProd(String cmdId, String paramStr, String cmdDisRuleId, String cmdParamCode, String cmdPriority) {
        String mainProdId = cmdId.split("_")[0];
        String mainActionId = cmdId.split("_")[1];
        TdWoCmddisrule cmddisrule = this.getCmddisrule(cmdDisRuleId, mainProdId, mainActionId, mainProdId, mainActionId, cmdParamCode, cmdId, cmdPriority);
        List<TdWoCmdparam> params = this.getParams(cmdParamCode, paramStr);
        tdWoCmddisruleMapper.insertSelective(cmddisrule);
        if (!CollectionUtils.isEmpty(params)) {
            tdWoCmdparamMapper.insertList(params);
        }
    }
}
