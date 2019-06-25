package com.snwki.junit.web;

import com.snwki.junit.model.Result;
import com.snwki.junit.model.User;
import com.snwki.junit.service.IUserService;
import com.snwki.junit.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{userId}")
    public Result getUser(@PathVariable("userId") int userId) {
        User user = userService.getById(userId);
        return ResultUtils.successResult(user);
    }

    @PostMapping("/user")
    public Result saveUser(@RequestBody User user) {
        int userId = userService.save(user);
        return ResultUtils.successResult(userId);
    }
}
