package cn.LysGroup.service.impl;

import cn.LysGroup.dao.userDao;
import cn.LysGroup.domain.User;
import cn.LysGroup.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl  implements userService {
    @Autowired
    private userDao dao;
    @Override
    public String findByName(String name) {
            User byName = dao.findByName(name);
            if(byName !=null) {
                return "此用户名已经被注册";
            }
            else {
            return "此用户名可用";
        }
    }

    @Override
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Override
    public User login(User user) {
        User u = dao.login(user);
        return u;
    }
}
