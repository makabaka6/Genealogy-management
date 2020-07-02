package cn.LysGroup.service;

import cn.LysGroup.domain.User;

public interface userService {
    /**
     * 通过姓名查询是否存在该用户
     * @param name
     * @return
     */
    String findByName(String name);
    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);
    /**
     * 查询用户的账号和密码是否正确
     * @param user
     * @return
     */
    User login(User user);
    /**
     * 更改用户的密码
     * @param user
     */
    void updatePassword(User user);
}
