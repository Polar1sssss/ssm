package cn.itcast.mybatis.po;

import java.util.Date;
import java.util.List;

/**
 * @author hujtb
 * @create on 2018-09-04-10:48
 */
public class User {
    private int id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;
    private List<Orders> ordersList;

    public List<Orders> getOrders() {
        return ordersList;
    }

    public void setOrders(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
