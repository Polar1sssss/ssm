package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

import java.util.List;

/**
 * @author hujtb
 * @create on 2018-09-04-14:26
 * 方法名必须跟mapper.xml中的statement id一致
 * 返回值类型跟returnType一致
 * 参数类型跟parameterType一致
 * mapper.xml中的namesapce值跟mapper接口的路径一致
 */
public interface UserMapper {
    public List<UserCustom> findUserList(UserQueryVo user) throws Exception;
    public User selectUserById(int id) throws Exception;
    public List<User> selectUserByName(String username) throws Exception;
    public void insertUser(User user) throws Exception;
    public void updateUser(User user) throws Exception;
    public void deleteUser(int id) throws Exception;
}
