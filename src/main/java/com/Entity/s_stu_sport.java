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
public class s_stu_sport {
    @TableId(type = IdType.AUTO)

    private Integer id;
    private Integer stu_id;
    private Integer like_sport_id;

}
