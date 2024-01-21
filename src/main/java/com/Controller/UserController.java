package com.Controller;


import com.Entity.s_user;
import com.Service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

//允许跨域 allowCredentials、origins必须填
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8080","http://localhost:*"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 账号密码登陆
     * @param user 用户
     * @return 用户
     */
    @GetMapping("/login1")
    public s_user login1(s_user user){
        return userService.login1(user);
    }

//    资金不允许 暂时关闭
    /**
     * 获取验证码
     * @param phone 电话号码
     * @return 验证码
     */

    @GetMapping("/getCode")
    public String getCode(String phone, HttpSession session){
        System.out.println(phone);
        return userService.getCode(phone,session);
    }

    /**
     * 检验验证码
     * @param phone 手机号
     * @param code 验证码
     * @param session session
     * @return Boolean
     */
    @GetMapping("/login2")
    public Boolean login2(String phone,String code,HttpSession session){
        return userService.login2(phone,code,session);
    }

    /**
     * 修改密码
     * @param user 用户名
     * @return Boolean
     */
    @PutMapping("/update")
    public Boolean update(@RequestBody s_user user){
        return userService.update(user);
    }

}
