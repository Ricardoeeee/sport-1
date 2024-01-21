package com.Dao;
import com.Entity.s_stu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
@ResponseBody

public interface StuDao extends BaseMapper<s_stu>{
    @Select("select count(*) from s_stu  where age>#{start} and age<=#{end}")
    int selectbyage(@Param("start") int start, @Param("end") int end);


    @Select("select distinct s_stu.sex,s_stu.sportdate,s_stu.sporttime from s_stu where sex = #{sex} ORDER BY sportdate")
    List<s_stu> aaa(@Param("sex") String sex);

    @Select("select distinct sport from s_stu")
    List<s_stu> SelectSportStu();

}
