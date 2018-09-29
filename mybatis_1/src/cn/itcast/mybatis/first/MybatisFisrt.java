package cn.itcast.mybatis.first;

import cn.itcast.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author hujtb
 * @create on 2018-09-04-10:55
 */
public class MybatisFisrt {


    public void findUserByIdTest() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        User user = sqlSession.selectOne("selectUserById", 1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void findUserByNameTest() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        List<User> list = sqlSession.selectList("selectUserByName", "zhang");
        System.out.println(list);
        sqlSession.close();
    }


    public void insertUserTest() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        User user = new User();
        user.setUsername("hanxin");
        user.setBirthday(new Date());
        user.setSex("M");
        user.setAddress("han");
        sqlSession.insert("insertUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        User user = new User();
        user.setId(2);
        user.setUsername("daji");
        user.setAddress("shang");
        user.setBirthday(new Date());
        user.setSex("W");
        sqlSession.update("updateUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        sqlSession.delete("deleteUser", 1);
        sqlSession.commit();
        sqlSession.close();
    }
}
