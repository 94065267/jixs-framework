package com.jixs.mybatis;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jixs.MybatisBootstrap;
import com.jixs.mybatis.mapper.TUserMapper;
import com.jixs.mybatis.po.TUser;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: jixs
 * @date: 2020-07-22
 */
@Slf4j
@SpringBootTest(classes = MybatisBootstrap.class)
@RunWith(SpringRunner.class)
public class MybatisTest {

    @Resource
    private TUserMapper tUserMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void add() {
        TUser user = new TUser();
        user.setUserId("2020080601");
        user.setUserName("2020080601");
        user.setUserCode("2020080601");
        //枚举类处理器,修改pojo对象改成enum类型
//        user.setUserSex(SexEnum.UNKNOWN);
        user.setUserSex(1);
        user.setUserAddress("2020080601");
        user.setUserTel("2020080601");
        user.setNote("2020080601");
        user.setCreateTime(DateUtil.now());
        int cnt = tUserMapper.insert(user);
        log.info("cnt = {}", cnt);
    }

    @SneakyThrows
    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    //测试默认事务不会提交，需要手动提交
    @Commit
    public void batchAdd() {
        StopWatch stopwatch = new StopWatch("50条数据插入数据耗时");
        stopwatch.start("单条分50次插入");
        for (int i = 1101; i <= 1150; i++) {
            String key = "20200813" + String.format("%04d", i + 1);
            tUserMapper.insert(new TUser(key));
        }
        stopwatch.stop();
        stopwatch.start("批量插入");
        List<TUser> userList = new ArrayList<>(64);
        for (int i = 1151; i <= 1200; i++) {
            String key = "20200813" + String.format("%04d", i + 1);
            userList.add(new TUser(key));
        }
        tUserMapper.insertList(userList);
        stopwatch.stop();
        log.info("总共用时 {} ms", stopwatch.prettyPrint());
    }

    @Test
    public void selectByPrimaryKey() {
        TUser user = tUserMapper.selectByPrimaryKey("2020080402");
        log.info("user = {}", JSONObject.toJSONString(user));
    }

    @Test
    public void select() {
        TUser userParam = new TUser();
//        userParam.setNote("测试");
//        userParam.setCreateTimeStart(DateUtil.yesterday());
//        userParam.setCreateTimeEnd(DateUtil.now());
        List<TUser> list = tUserMapper.select(userParam);
//        List<TUser> list = tUserMapper.select(userParam, new RowBounds(0, 10));
        log.info("list = {}", JSONArray.toJSONString(list));
    }


    @Test
    public void cacheTest() {
        //sqlSession1
        System.out.println("sqlSession1 开始。。。。。。。。。。。。。。。。。。。。");
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        TUserMapper mapper1 = sqlSession1.getMapper(TUserMapper.class);
        mapper1.selectByPrimaryKey("2020073001");
//        TUser userParaintm = new TUser();
//        userParam.setUserId("2020073001");
//        userParam.setNote("测试");
//        mapper1.updateByPrimaryKey(userParam);
        System.out.println("同一sqlsession中同一sql,用到一级缓存，如果缓存级别session（默认级别）,那么接下来这个查询不会再执行查询，直接从缓存中获取");
        mapper1.selectByPrimaryKey("2020073001");
        sqlSession1.commit();
        System.out.println("sqlSession1 结束。。。。。。。。。。。。。。。。。。。。");
        //sqlSession2
        System.out.println("sqlSession2 开始。。。。。。。。。。。。。。。。。。。。");
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        TUserMapper mapper2 = sqlSession2.getMapper(TUserMapper.class);
        System.out.println("非同一sqlsession中同一sql，如果开启了缓存，那么接下来这个查询不会在执行查询，直接从缓存中获取");
        mapper2.selectByPrimaryKey("2020073001");
        sqlSession2.commit();
        System.out.println("sqlSession2 结束。。。。。。。。。。。。。。。。。。。。");

    }
}
