package com.jixs.mybatisplus;

import com.jixs.TkmybatisBootstrap;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: jixs
 * @date: 2020-07-22
 */
@Slf4j
@SpringBootTest(classes = TkmybatisBootstrap.class)
@RunWith(SpringRunner.class)
public class MybatisplusTest {
    @Resource
//    private TUserMapper tUserMapper;

    @Test
    public void qryOrdById() {
//        TUser user = new TUser();
//        user.setUserName("冀晓爽");
//        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
//        wrapper.setEntity(user);
//        List<TUser> list = tUserMapper.selectList(wrapper);
//        log.info("list = {}", JSONArray.toJSONString(list));
    }

}
