package cn.itcast.mybatis.po;

/**
 * @author hujtb
 * @create on 2018-09-06-17:23
 * ͨ������ӳ��user��orders�Ĳ�ѯ������ô���̳��ֶν϶��pojo��
 */
public class OrdersCustom extends Orders{
    //����û�������
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
