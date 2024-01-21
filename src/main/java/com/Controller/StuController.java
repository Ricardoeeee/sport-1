package com.Controller;

import com.Entity.s_stu;
import com.Service.StuService;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stu")
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8080","http://10.152.195.206:8080","http://192.168.157.15:8080"})
public class StuController {
    @Resource
    private StuService stuService;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/SelectByType")
    public List<s_stu> SelectByType(String type){
        return stuService.SelectByType(type);
    }

    @GetMapping("/SelectSportStu")
    public Map<String, Object> SelectSportStu(){
        return stuService.SelectSportStu();
    }

    @GetMapping("/selectbyage")
    public Map<String, Object> selectbyage(){
        return stuService.selectbyage();
    }

    @GetMapping("/selectbytime")
    public Map<String,Object> selectbytime(){
        return stuService.selectbytime();
    }

    @GetMapping("/sportlist")
    public List<s_stu> sportlist(){
       return stuService.selectAll();
    }
}
