package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.JwtTokenUtils;
import com.example.common.Result;
import com.example.entity.User;
import com.example.entity.Params;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {

        User loginUser = userService.login(user);
        return Result.success(loginUser);
    }

    @PostMapping("/password")
    public Result updatePassword(@RequestBody User user) {
        User currentUser = JwtTokenUtils.getCurrentUser();
        if (ObjectUtil.isNull(currentUser)) {
            return Result.error("token验证失效，请重新登陆");
        }
        if (!user.getPassword().equals(currentUser.getPassword())) {
            return Result.error("原密码输入错误");
        }
        user.setPassword(user.getNewPassword());
        userService.update(user);
        return Result.success();
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.add(user);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody User user) {
        if (user.getId() == null) {
            userService.add(user);
        } else {
            userService.update(user);
        }
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        List<User> list = userService.findAll();
        return Result.success(list);
    }

    @GetMapping("/search")
    public Result findBySearch(Params params) {
        PageInfo<User> info = userService.findBySearch(params);
        return Result.success(info);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        userService.delete(id);
        return Result.success();
    }
}
