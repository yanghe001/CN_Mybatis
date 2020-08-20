package pojo;

import java.util.List;

/**
 * 类属性名需跟数据库中属性名一样 [不区分大小写]
 * 如果类的属性名想指定其他的 可以查询时采用别名或者使用对应关系
 */
public class User {

    private Integer id;
    private String name;
    private Integer age;

    //用户详细信息  User：UserInfo 1:1
    private UserInfo userInfo;

    //用户订单 User:Order  1:n
    List<Order> orderList;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", userInfo=" + userInfo +
                ", orderList=" + orderList +
                '}';
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

}
