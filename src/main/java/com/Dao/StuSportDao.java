package com.Dao;

import com.Entity.s_stu_sport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.ResponseBody;

@Mapper
@ResponseBody
public interface StuSportDao extends BaseMapper<s_stu_sport> {
}
