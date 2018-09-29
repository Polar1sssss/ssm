package cn.itcast.ssm.test;

import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * ‘≠ ºDao≤‚ ‘¿‡
 * @author hujtb
 * @create on 2018-09-04-15:21
 */
public class UserDaoImplTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    }
    @Test
    public void testFindUserById() throws Exception{
        UserMapper dao = (UserMapper)applicationContext.getBean("userMapper");
        User user = dao.selectUserById(2);
        System.out.println(user);
    }
}
