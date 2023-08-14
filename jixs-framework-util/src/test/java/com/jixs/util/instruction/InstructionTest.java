package com.jixs.util.instruction;

import com.sitech.iom.Bootstrap;
import com.sitech.iom.Instruction;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
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

    @Test
    public void test() throws IOException {
        String filePath = "D:\\Work\\si-tech\\文档\\各个省份\\联通国际\\云B激活升级项目\\指令梳理\\预付费开户主动作附加服务梳理-jixs.xlsx";
        String sheetName = "HK000001_10270";
        String cmdDisRuleIdPreFix = "HK1003";
        List<String> subActionIds = Arrays.asList("A", "R");
        instruction.add(filePath, sheetName, cmdDisRuleIdPreFix, subActionIds);
    }

}
