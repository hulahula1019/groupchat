package com.example.dao;

import com.example.entity.User;
import com.example.entity.Params;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserDao extends Mapper<User> {

    List<User> findBySearch(@Param("params") Params params);

    @Select("select * from user where name = #{name} limit 1")
    User findByName(@Param("name") String name);

    @Select("select * from user where name = #{name} and password = #{password} limit 1")
    User findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
