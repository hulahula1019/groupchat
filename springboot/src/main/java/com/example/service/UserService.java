package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.JwtTokenUtils;
import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.entity.Params;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.selectAll();
    }

    public PageInfo<User> findBySearch(Params params) {
        // 开启分页查询
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        // 接下来的查询会自动按照当前开启的分页设置来查询
        List<User> list = userDao.findBySearch(params);
        return PageInfo.of(list);
    }

    public void add(User admin) {
        // 1. 用户名一定要有，否则不让新增（后面需要用户名登录）
        if (admin.getName() == null || "".equals(admin.getName())) {
            throw new CustomException("用户名不能为空");
        }
        // 2. 进行重复性判断，同一名字的管理员不允许重复新增：只要根据用户名去数据库查询一下就可以了
        User user = userDao.findByName(admin.getName());
        if (user != null) {
            // 说明已经有了，这里我们就要提示前台不允许新增了
            throw new CustomException("该用户名已存在，请更换用户名");
        }
        // 初始化一个密码
        if (admin.getPassword() == null) {
            admin.setPassword("123456");
        }
        if (ObjectUtil.isEmpty(admin.getAvatar())) {
            admin.setAvatar("http://localhost:8080/files/qy-default.png");
        }
        userDao.insertSelective(admin);
    }

    public void update(User user) {
        userDao.updateByPrimaryKeySelective(user);
    }

    public void delete(Integer id) {
        userDao.deleteByPrimaryKey(id);
    }

    public User login(User admin) {
        // 1. 进行一些非空判断
        if (admin.getName() == null || "".equals(admin.getName())) {
            throw new CustomException("用户名不能为空");
        }
        if (admin.getPassword() == null || "".equals(admin.getPassword())) {
            throw new CustomException("密码不能为空");
        }
        // 2. 从数据库里面根据这个用户名和密码去查询对应的管理员信息，
        User user = userDao.findByNameAndPassword(admin.getName(), admin.getPassword());
        if (user == null) {
            // 如果查出来没有，那说明输入的用户名或者密码有误，提示用户，不允许登录
            throw new CustomException("用户名或密码输入错误");
        }
        // 如果查出来了有，那说明确实有这个管理员，而且输入的用户名和密码都对；
        // 生成该登录用户对应的token，然后跟着user一起返回到前台
        String token = JwtTokenUtils.genToken(user.getId().toString(), user.getPassword());
        user.setToken(token);
        return user;
    }

    public User findById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }
}
