package cn.itcast.mybatis.test;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.dao.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * ‘≠ ºDao≤‚ ‘¿‡
 * @author hujtb
 * @create on 2018-09-04-15:21
 */
public class UserDaoImplTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws IOException{
        String resource = "SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

    }
    @Test
    public void testFindUserBy(){
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        userDao.findUserById(2);
    }
}
