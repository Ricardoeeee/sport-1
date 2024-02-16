package com.Dao;

import com.Entity.s_sport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.ResponseBody;

@Mapper
@ResponseBody
public interface SportDao extends BaseMapper<s_sport> {
}
