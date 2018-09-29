package cn.itcast.mybatis.test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 原始Dao测试类
 * @author hujtb
 * @create on 2018-09-04-15:21
 */
public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws IOException{
        String resource = "SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

    }
    @Test
    public void testFindUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.selectUserById(2);

    }

    @Test
    public void testFindUserList() throws  Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //创建包装对象
        UserQueryVo userQueryVo = new UserQueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        UserCustom userCustom = new UserCustom();
        //userCustom.setSex("W");
        userCustom.setUsername("daji");
        userQueryVo.setIds(list);
        userQueryVo.setUserCustomer(userCustom);

        List<UserCustom> userCustoms =  userMapper.findUserList(userQueryVo);
    }
}
