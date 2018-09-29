package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.User;


/**
 * @author hujtb
 * @create on 2018-09-04-14:26
 * 方法名必须跟mapper.xml中的statement id一致
 * 返回值类型跟returnType一致
 * 参数类型跟parameterType一致
 * mapper.xml中的namesapce值跟mapper接口的路径一致
 */
public interface UserMapper {
    public User selectUserById(int id) throws Exception;
}
