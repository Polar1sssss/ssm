package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;

/**
 * @author hujtb
 * @create on 2018-09-04-14:26
 */
public interface UserDao {
    public User findUserById(int id);
    public User findUserByName(String username);
    public void insertUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
}
