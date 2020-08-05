package com.jixs.mybatis;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jixs.MybatisBootstrap;
import com.jixs.mybatis.mapper.TUserMapper;
import com.jixs.mybatis.po.TUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
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
        user.setUserId("2020080404");
        user.setUserName("2020080404");
        user.setUserCode("2020080404");
        //枚举类处理器,修改pojo对象改成enum类型
//        user.setUserSex(SexEnum.UNKNOWN);
        user.setUserSex(1);
        user.setUserAddress("2020080404");
        user.setUserTel("2020080404");
        user.setNote("2020080404");
        user.setCreateTime(DateUtil.now());
        int cnt = tUserMapper.insert(user);
        log.info("cnt = {}", cnt);
    }

    @Test
    public void selectByPrimaryKey() {
        TUser user = tUserMapper.selectByPrimaryKey("2020080402");
        log.info("user = {}", JSONObject.toJSONString(user));
    }

    @Test
    public void select() {
//        PageHelper.startPage(3, 10, false);
        TUser userParam = new TUser();
        userParam.setNote("测试");
        userParam.setCreateTimeStart(DateUtil.yesterday());
        userParam.setCreateTimeEnd(DateUtil.now());
//        List<TUser> list = tUserMapper.select(userParam);
        //分页查询
        List<TUser> list = tUserMapper.select(userParam, new RowBounds(20, 10));
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
