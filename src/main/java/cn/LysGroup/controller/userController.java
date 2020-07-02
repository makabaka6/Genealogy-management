package cn.LysGroup.controller;

import cn.LysGroup.domain.User;
import cn.LysGroup.service.userService;
import cn.LysGroup.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//用户控制类
@Controller
@RequestMapping("/user")
@SessionAttributes("user")//把数据存入到session域对象中
public class userController {
    @Autowired
    private userService service;
    @Autowired
    private ResultInfo info;
    /**
     * 异步验证用户名是否存在
     * @return
     */
    @RequestMapping("/findNameIsExist")
    public @ResponseBody ResultInfo findNameIsExist(String username){
        String msg = service.findByName(username);
        if(msg.equals("此用户名已经被注册")){
            info.setFlag(false);
        }
        else {
            info.setFlag(true);
        }
        info.setErrorMsg(msg);
        return info;
    }

    /**
     * 注册用户
     * @param user
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/register")
    public @ResponseBody ResultInfo registerUser(@RequestBody User user){
        try {
            service.saveUser(user);
            info.setFlag(true);
            info.setErrorMsg("注册成功");
            return info;
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("注册失败，请联系管理员");
            return info;
        }
    }

    /**
     * 登录
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public @ResponseBody ResultInfo login(@RequestBody User user, Model model){
        User login = service.login(user);
        if(login==null){
            info.setErrorMsg("账号或密码错误");
            info.setFlag(false);
            return info;
        }
        else {
            info.setFlag(true);
            info.setErrorMsg("登陆成功");
            //把值存入session中
            model.addAttribute("user",login);
            return info;
        }
    }

    /**
     * 退出，销毁session保存的用户
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request) throws IOException {
        //销毁session
        request.getSession().invalidate();
        //跳转到登录页面
        return "index";
    }

    /**
     * 登录成功后，显示登录人的昵称
     * @param map
     * @return
     */
    @RequestMapping("/findUser")
    public @ResponseBody User findUser(ModelMap map){
        //从session中获取值
        Object user = map.get("user");
        //返回数据
        return (User) user;
    }

    /**
     * 更改用户的密码
     * @return
     */
    @RequestMapping("/updatePassword")
    public @ResponseBody ResultInfo updatePassword(@RequestBody String password,ModelMap map){
        //从session中获取值
        Object user = map.get("user");
        //强转为user对象
        User user1=(User)user;
        //设置新密码
        user1.setUpassword(password);
        //调用service
        try {
            //如果修改成功
            service.updatePassword(user1);
            info.setFlag(true);
            info.setErrorMsg("密码修改成功");
            return info;
        } catch (Exception e) {
            //修改失败
            info.setFlag(false);
            info.setErrorMsg("密码修改错误，请联系管理员");
            return info;
        }
    }
}
