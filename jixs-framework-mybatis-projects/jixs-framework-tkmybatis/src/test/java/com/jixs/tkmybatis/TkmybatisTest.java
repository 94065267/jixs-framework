package com.jixs.tkmybatis;

import com.alibaba.fastjson.JSONArray;
import com.jixs.TkmybatisBootstrap;
import com.jixs.tkmybatis.mapper.SingleTableMapper;
import com.jixs.tkmybatis.mapper.TfGsOrderMapper;
import com.jixs.tkmybatis.mapper.TfSoOrderMapper;
import com.jixs.tkmybatis.po.SingleTable;
import com.jixs.tkmybatis.po.TfSoOrder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.IDynamicTableName;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: jixs
 * @date: 2020-07-22
 */
@Slf4j
@SpringBootTest(classes = TkmybatisBootstrap.class)
@RunWith(SpringRunner.class)
public class TkmybatisTest {
    @Resource
    private TfGsOrderMapper tfGsOrderMapper;
    @Resource
    private TfSoOrderMapper tfSoOrderMapper;
    @Resource
    private SingleTableMapper singleTableMapper;

    @Test
    public void qryOrdById() {
//        TfGsOrder order = tfGsOrderMapper.selectByPrimaryKey("O2020070300000010");
//        TfGsOrder order = new TfGsOrder();
//        tfGsOrderMapper.selectByRowBounds(order, new RowBounds(10,10));
//        PageHelper.startPage(3, 10, false);
//        tfGsOrderMapper.selectAll();

        //example用法
//        Example example = new Example(TfGsOrder.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("gsType", "A");
//        example.setOrderByClause("ACCEPT_TIME desc");
//        criteria.andBetween("acceptTime", DateUtil.now(), DateUtil.now());
//        List<TfGsOrder> list = tfGsOrderMapper.selectByExample(example);
//        log.info("order = {}", JSONArray.toJSONString(list));

        System.out.println(IDynamicTableName.class.isAssignableFrom(TfSoOrder.class));

        Example example = new Example(TfSoOrder.class);
        example.setTableName("tf_so_order_00");
        Example.Criteria criteria = example.createCriteria();
        List<TfSoOrder> list = tfSoOrderMapper.selectByExample(example);
        log.info("order = {}", JSONArray.toJSONString(list));
    }

    @Test
    public void insert() {
        for (int i = 0; i < 10000; i++) {
            SingleTable singleTable = new SingleTable();
            singleTable.setKey1(String.valueOf(Math.random() * 10000 + 10000));
            singleTable.setKey2(10000 - i);
            singleTable.setKey3(String.valueOf(Math.random() * 10000 + 10000));
            singleTable.setKeyPart1(singleTable.getKey1() + " - Part1");
            singleTable.setKeyPart2(singleTable.getKey2() + " - Part2");
            singleTable.setKeyPart3(singleTable.getKey3() + " - Part3");
            singleTable.setCommonField(String.valueOf(System.currentTimeMillis()));
            singleTableMapper.insertSelective(singleTable);
        }
    }

}
