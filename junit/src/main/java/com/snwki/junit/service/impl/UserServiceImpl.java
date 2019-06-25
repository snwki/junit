package com.snwki.junit.service.impl;

import com.snwki.junit.mapper.UserMapper;
import com.snwki.junit.model.User;
import com.snwki.junit.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Integer userId) {
        return userMapper.getById(userId);
    }

    @Override
    public Integer save(User user) {
        return userMapper.save(user);
    }
}
