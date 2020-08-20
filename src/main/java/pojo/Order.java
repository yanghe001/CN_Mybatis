package pojo;

/**
 * 订单  User:Order 1:n
 */
public class Order {
    private Integer id;
    private Integer user_id;
    private String name;

    public Integer getId() {
        return id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", name='" + name + '\'' +
                '}';
    }
}
