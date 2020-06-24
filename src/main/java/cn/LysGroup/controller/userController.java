package cn.LysGroup.controller;

import cn.LysGroup.domain.User;
import cn.LysGroup.service.userService;
import cn.LysGroup.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public @ResponseBody ResultInfo registerUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
}
