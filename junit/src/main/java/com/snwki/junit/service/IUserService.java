package com.snwki.junit.service;

import com.snwki.junit.model.User;

public interface IUserService {

    User getById(Integer userId);

    Integer save(User user);
}
