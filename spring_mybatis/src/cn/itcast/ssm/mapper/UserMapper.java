package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.User;


/**
 * @author hujtb
 * @create on 2018-09-04-14:26
 * �����������mapper.xml�е�statement idһ��
 * ����ֵ���͸�returnTypeһ��
 * �������͸�parameterTypeһ��
 * mapper.xml�е�namesapceֵ��mapper�ӿڵ�·��һ��
 */
public interface UserMapper {
    public User selectUserById(int id) throws Exception;
}
