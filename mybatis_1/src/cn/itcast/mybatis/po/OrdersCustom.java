package cn.itcast.mybatis.po;

/**
 * @author hujtb
 * @create on 2018-09-06-17:23
 * 通过此类映射user和orders的查询结果，让此类继承字段较多的pojo类
 */
public class OrdersCustom extends Orders{
    //添加用户的属性
    private String username;
    private String sex;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
