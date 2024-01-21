package com.Service;

import com.Dao.StuDao;
import com.Entity.s_stu;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class StuService {
    @Resource
    private StuDao stuDao;

    public List<s_stu> SelectByType(String type) {
        s_stu stu = new s_stu();
        QueryWrapper<s_stu> wrapper = new QueryWrapper<>(stu);
        List<s_stu> map = stuDao.selectList(wrapper);
        System.out.println(map);
        return map;
    }

    public Map<String, Object> SelectSportStu() {
        List<s_stu> s_list = stuDao.SelectSportStu();
        List<String> list_n = new ArrayList<>();
        List<Integer> list_s = new ArrayList<>();
        for (s_stu sStu : s_list) {
            list_n.add(sStu.getSport());
        }
        System.out.println(list_n);
        for (s_stu sStu : s_list) {
            s_stu stu = new s_stu();
            stu.setSport(sStu.getSport());
            QueryWrapper<s_stu> wrapper = new QueryWrapper<>(stu);
            list_s.add(stuDao.selectList(wrapper).size());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("运动类型",list_n);
        map.put("运动人数",list_s);
        System.out.println(map);
        return map;
//        s_stu stu = new s_stu();
//        stu.setSport(sport);
//        QueryWrapper<s_stu> wrapper = new QueryWrapper<>(stu);
//        return stuDao.selectList(wrapper).size();
    }

    public Map<String, Object> selectbyage() {
        int end = 40, now = 10;
        List<Integer> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        while (now < end) {
            int a = stuDao.selectbyage(now, now + 3);
            list.add(a);
            list2.add(now + "-" + (now + 3));
            now += 3;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("年龄段", list2);
        map.put("人数", list);
        return map;
    }

    public Map<String, Object> selectbytime() {
        List<s_stu> list = stuDao.aaa("男");
        List<s_stu> list2 = stuDao.aaa("女");
        List<String> list_t = new ArrayList<>();
        List<Integer> list_1 = new ArrayList<>();
        List<Integer> list_0 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list_t.add(list.get(i).getSportdate() + ":00");
            list_0.add(list2.get(i).getSporttime());
            list_1.add(list.get(i).getSporttime());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("运动时间", list_t);
        map.put("男运动时长", list_0);
        map.put("女运动时长", list_1);
        return map;
    }


    public List<s_stu> selectAll(){
        QueryWrapper<s_stu> queryWrapper =new QueryWrapper<>();
        return stuDao.selectList(queryWrapper);
    }

}
