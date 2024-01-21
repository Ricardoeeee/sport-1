package com.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//创建构造器
@AllArgsConstructor
@NoArgsConstructor

public class s_stu {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
    String sex;
    Integer age;
    String sport;
    Integer sportdate;
    Integer sporttime;
}
