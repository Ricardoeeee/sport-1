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
public class s_sport_dto {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String father;
    private String type;
    private String path;
    private String introduce;
    private Integer likes;



}
