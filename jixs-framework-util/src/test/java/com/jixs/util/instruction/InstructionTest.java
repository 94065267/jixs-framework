package com.jixs.util.instruction;

import com.sitech.iom.Bootstrap;
import com.sitech.iom.Instruction;
import com.sitech.iom.wo.dao.mapper.TdWoCmddisruleMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 说明：文件说明
 *
 * @author jixs_bj
 * @date 2023/8/11 9:28
 */
@Slf4j
@SpringBootTest(classes = Bootstrap.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class InstructionTest {
    @Resource
    private Instruction instruction;
    @Resource
    private TdWoCmddisruleMapper tdWoCmddisruleMapper;

    @Test
    public void test() {
        String filePath = "D:\\Work\\si-tech\\文档\\各个省份\\联通国际\\云B激活升级项目\\指令梳理\\预付费开户主动作附加服务梳理-jixs.xlsx";
        List<String> sheets = Arrays.asList("HK000001_13620", "HK000001_10210", "HK000001_10270");
        for (String s : sheets) {
            // 读取excel
            Sheet sheet = instruction.readSheet(filePath, s);
            if (sheet == null) {
                log.error("excel文件{}没有获取到sheet页【{}】：", filePath, s);
                return;
            }
            String mainProdId = s.split("_")[0];
            String mainActionId = s.split("_")[1];
            log.info("主服务：{}，主动作：{}", mainProdId, mainActionId);
            log.info("最后一行的编号：{}", sheet.getLastRowNum());
        }
        tdWoCmddisruleMapper.selectByPrimaryKey("D1100000001");
    }

    @Test
    public void mainProd1() {
        List<String> cmdList = Arrays.asList("HK000001_13620", "HK000001_10210", "HK000001_13622", "HK000001_10270");
        List<String> paramList = Arrays.asList(
                "ISDN|SUBTEMPID|VLRTPLID|SGSNTPLID|DIAMNODETPLID|isVolte|opid|TPLID|TPLOPT|SM_SRVNAME|IMSI|SUBIMSI",
                "ISDN|VLRTPLID|SGSNTPLID|DIAMNODETPLID|IMSI|SRVNAME|SEND_FLAG",
                "ISDN|isVolte|SUBTEMPID|IMSI|NEWHKISDN|OLDHKISDN",
                "ISDN|SUBTEMPID|VLRTPLID|SGSNTPLID|DIAMNODETPLID|isVolte|opid|TPLID|TPLOPT|SM_SRVNAME|IMSI");
        String cmdPriority = "111";
        for (int i = 0; i < cmdList.size(); i++) {
            String cmdDisRuleId = "D110000000" + (i + 1);
            String cmdParamCode = "P110000000" + (i + 1);
            instruction.addMainProd(cmdList.get(i), paramList.get(i), cmdDisRuleId, cmdParamCode, cmdPriority);
        }
    }

    @Test
    public void mainProd2() {
        List<String> cmdList = Arrays.asList("HK000002_13620", "HK000002_10210", "HK000002_13622", "HK000002_10270");
        List<String> paramList = Arrays.asList(
                "ISDN|SUBTEMPID|VLRTPLID|SGSNTPLID|DIAMNODETPLID|TPLID|TPLOPT|SM_SRVNAME|IMSI",
                "IMSI|SRVNAME|SEND_FLAG",
                "IMSI|SRVNAME|NEWHKISDN|OLDHKISDN|SEND_FLAG",
                "ISDN|SUBTEMPID|VLRTPLID|SGSNTPLID|DIAMNODETPLID|TPLID|TPLOPT|SM_SRVNAME|IMSI");
        String cmdPriority = "111";
        for (int i = 0; i < cmdList.size(); i++) {
            String cmdDisRuleId = "D120000000" + (i + 1);
            String cmdParamCode = "P120000000" + (i + 1);
            instruction.addMainProd(cmdList.get(i), paramList.get(i), cmdDisRuleId, cmdParamCode, cmdPriority);
        }
    }

    @Test
    public void subProd() {
        String filePath = "D:\\Work\\si-tech\\文档\\各个省份\\联通国际\\云B激活升级项目\\指令梳理\\预付费开户主动作附加服务梳理-jixs.xlsx";
        List<String> sheets = Arrays.asList("HK000001_13620", "HK000001_10210", "HK000001_10270");
        List<String> subActionIds = Arrays.asList("A", "R");
        String cmdPriority = "222";
        for (int i = 0; i < sheets.size(); i++) {
            String cmdDisRuleIdPreFix = "D20000" + (i + 1);
            String cmdParamCodePreFix = "P20000" + (i + 1);
            instruction.addSubProd(filePath, sheets.get(i), cmdDisRuleIdPreFix, cmdParamCodePreFix, subActionIds, cmdPriority);
        }
    }

    @Test
    public void subProd2() {
        String filePath = "D:\\Work\\si-tech\\文档\\各个省份\\联通国际\\云B激活升级项目\\指令梳理\\预付费开户主动作附加服务梳理-jixs2.xlsx";
        List<String> sheets = Arrays.asList("HK000002_13620", "HK000002_10210", "HK000002_10270");
        List<String> subActionIds = Arrays.asList("A", "R");
        String cmdPriority = "222";
        for (int i = 0; i < sheets.size(); i++) {
            String cmdDisRuleIdPreFix = "D21000" + (i + 1);
            String cmdParamCodePreFix = "P21000" + (i + 1);
            instruction.addSubProd(filePath, sheets.get(i), cmdDisRuleIdPreFix, cmdParamCodePreFix, subActionIds, cmdPriority);
        }
    }

}
