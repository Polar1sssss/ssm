package cn.itcast.mybatis.po;

import java.util.List;

/**
 * 包装类型
 * @author hujtb
 * @create on 2018-09-04-15:36
 */
public class UserQueryVo {
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    private UserCustom userCustom;

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustomer(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
