package com.jixs.muldb;

import com.jixs.MulDbBootstrap;
import com.jixs.dao.mapper.db1.TdSoSysconfigMapper;
import com.jixs.dao.mapper.db2.TdWoSysconfigMapper;
import com.jixs.dao.po.db1.TdSoSysconfig;
import com.jixs.dao.po.db2.TdWoSysconfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 说明
 *
 * @author jixs
 * @date 2021-12-15 11:13
 */
@Slf4j
@SpringBootTest(classes = MulDbBootstrap.class)
@RunWith(SpringRunner.class)
public class MulDbTest {
    @Resource
    private TdSoSysconfigMapper tdSoSysconfigMapper;
    @Resource
    private TdWoSysconfigMapper tdWoSysconfigMapper;

    @Test
    public void query() {
        TdSoSysconfig tdSoSysconfig = tdSoSysconfigMapper.selectByPrimaryKey("O001001");
        log.debug("tdSoSysconfig.getParaName()={}", tdSoSysconfig.getParaName());
        TdWoSysconfig tdWoSysconfig = tdWoSysconfigMapper.selectByPrimaryKey("W001000");
        log.debug("tdWoSysconfig.getParaName()={}", tdWoSysconfig.getParaName());
    }
}
