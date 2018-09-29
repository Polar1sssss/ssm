package cn.itcast.ssm.dao;

import cn.itcast.ssm.po.User;

/**
 * @author hujtb
 * @create on 2018-09-04-14:26
 */
public interface UserDao {
    public User findUserById(int id);
}
