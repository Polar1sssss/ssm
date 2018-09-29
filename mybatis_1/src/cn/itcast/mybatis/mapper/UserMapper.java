package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

import java.util.List;

/**
 * @author hujtb
 * @create on 2018-09-04-14:26
 * �����������mapper.xml�е�statement idһ��
 * ����ֵ���͸�returnTypeһ��
 * �������͸�parameterTypeһ��
 * mapper.xml�е�namesapceֵ��mapper�ӿڵ�·��һ��
 */
public interface UserMapper {
    public List<UserCustom> findUserList(UserQueryVo user) throws Exception;
    public User selectUserById(int id) throws Exception;
    public List<User> selectUserByName(String username) throws Exception;
    public void insertUser(User user) throws Exception;
    public void updateUser(User user) throws Exception;
    public void deleteUser(int id) throws Exception;
}
