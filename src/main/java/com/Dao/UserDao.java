package com.Dao;

import com.Entity.s_user;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.ResponseBody;

@Mapper
@ResponseBody
public interface UserDao extends BaseMapper<s_user> {

}
