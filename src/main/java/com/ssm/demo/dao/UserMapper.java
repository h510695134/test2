package com.ssm.demo.dao;

import com.ssm.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    User login(@Param("userName") String userName, @Param("password") String password);
}
