package com.Service;

import com.Dao.UserDao;
import com.Entity.s_user;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Objects;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    /**
     * 账号密码登陆
     *
     * @param SUser 账号/密码
     * @return 用户
     */
    public s_user login1(s_user SUser) {
        System.out.println(SUser);
        QueryWrapper<s_user> wrapper = new QueryWrapper<>(SUser);
        try {
            return userDao.selectOne(wrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取验证码
     *
     * @param phone 电话号码
     * @return 验证码
     */
    public String getCode(String phone, HttpSession session) {
        HashMap<String, Object> result;
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
        // 初始化服务器地址和端口，生产环境配置成app.cloopen.com，端口是8883.
        restAPI.init("app.cloopen.com", "8883");
        // 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在控制首页中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN。
        restAPI.setAccount("8aaf070882ede8b301833a56b5dc0d4d", "0ac16f09871647cb81d2b83d0bf53ffc");
        // 请使用管理控制台中已创建应用的APPID。
        restAPI.setAppId("8aaf070882ede8b301833a56b6f00d54");
        String code = RandomStringUtils.randomNumeric(6);
        //设置需要发送的手机号和发送的验证码及过期时间
        result = restAPI.sendTemplateSMS(phone, "1", new String[]{code, "10"});
        if ("000000".equals(result.get("statusCode"))) {
            session.setAttribute("phone", phone);
            session.setAttribute("code", code);
            System.out.println("验证码为:" + code);
            return code;
        } else {
            //异常返回输出错误码和错误信息
            return "错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg");
        }
    }

/*
//    public String getCode1(String phone,HttpSession session) {
//        System.out.println(phone);
//        String code=RandomStringUtils.randomAlphanumeric(6);
//        session.setAttribute("code",code);
//        System.out.println(code);
//        return code;
//    }
*/

    /**
     * 检验验证码
     *
     * @param phone   手机号
     * @param code    验证码
     * @param session session
     * @return Boolean
     */
    public Boolean login2(String phone, String code, HttpSession session) {
        System.out.println("手机号为：" + phone + " 正在登陆");
        String code1 = (String) session.getAttribute("code");
        return Objects.equals(code1, code);

    }

    /**
     * 修改密码
     *
     * @param user 账号/手机号/新密码
     * @return Boolean
     */
    public Boolean update(s_user user) {
        System.out.println(user);
        s_user user1 = new s_user(null, user.getUsername(), null, user.getPhone());
        QueryWrapper<s_user> wrapper = new QueryWrapper<>(user1);
        try {
            s_user user2 = userDao.selectOne(wrapper);
            user1.setId(user2.getId());
            user1.setPassword(user.getPassword());
            userDao.updateById(user1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
