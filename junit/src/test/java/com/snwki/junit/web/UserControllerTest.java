package com.snwki.junit.web;

import com.google.gson.Gson;
import com.snwki.junit.JunitApplication;
import com.snwki.junit.model.Result;
import com.snwki.junit.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {JunitApplication.class, DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
@AutoConfigureMockMvc
public class UserControllerTest extends AbstractTestHandler {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void getUser() {
        saveUser();
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/" + 1)).andReturn();
            String resultString = mvcResult.getResponse().getContentAsString();
            Result result = new Gson().fromJson(resultString, Result.class);
            assertEquals(result.getCode(), 0);
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");
        String param = new Gson().toJson(user);
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(param)).andReturn();
            String resultString = mvcResult.getResponse().getContentAsString();
            Result result = new Gson().fromJson(resultString, Result.class);
            assertEquals(result.getCode(), 0);
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testRedis(){
        String redisKey = "key";
        String redisValue = "value";
        stringRedisTemplate.opsForValue().set(redisKey, redisValue);
        assertEquals(redisValue, stringRedisTemplate.opsForValue().get(redisKey));
    }
}