package cn.itcast.ssm.dao;

import cn.itcast.ssm.po.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * 原始Dao开发方法
 * @author hujtb
 * @create on 2018-09-04-14:33
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

    public User findUserById(int id) {
        SqlSession sqlSession = this.getSqlSession();
        User user =  sqlSession.selectOne("test.selectUserById", 2);
        return user;
    }
}
