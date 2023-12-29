package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.JwtTokenUtils;
import com.example.dao.ImGroupDao;
import com.example.entity.ImGroup;
import com.example.entity.User;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service
public class ImGroupService {

    @Resource
    private ImGroupDao imGroupDao;

    public ImGroup add(ImGroup imGroup) {
        imGroupDao.insertSelective(imGroup);
        return imGroup;
    }

    public void delete(Integer id) {
        imGroupDao.deleteByPrimaryKey(id);
    }

    public void update(ImGroup imGroup) {
        imGroupDao.updateByPrimaryKeySelective(imGroup);
    }

    public ImGroup findById(Integer id) {
        return imGroupDao.selectByPrimaryKey(id);
    }

    public List<ImGroup> findAll() {
        return imGroupDao.findBySearch(null);
    }

    public PageInfo<ImGroup> findPage(ImGroup search, Integer pageNum, Integer pageSize) {
        User user = JwtTokenUtils.getCurrentUser();
        if (ObjectUtil.isNull(user)) {
            throw new CustomException("token验证失效");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<ImGroup> all = findByCondition(user, search);

        return PageInfo.of(all);
    }

    public List<ImGroup> findByCondition(User user, ImGroup search) {
		return imGroupDao.findBySearch(search);
    }
}