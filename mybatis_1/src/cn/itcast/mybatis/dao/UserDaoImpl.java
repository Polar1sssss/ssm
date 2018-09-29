package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 原始Dao开发方法
 * @author hujtb
 * @create on 2018-09-04-14:33
 */
public class UserDaoImpl implements UserDao{
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User findUserById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user =  sqlSession.selectOne("test.selectUserById", 2);
        sqlSession.close();
        return user;
    }

    @Override
    public User findUserByName(String username) {
        return null;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("test.updateUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUser", 1);
        sqlSession.commit();
        sqlSession.close();
    }
}
