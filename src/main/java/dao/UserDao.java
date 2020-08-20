package dao;

import org.apache.ibatis.annotations.Param;
import page.Page;
import pojo.User;
import java.util.List;

public interface UserDao {
    //基本操作
    User selectOne(int id);
    List<User> selectAll();
    List<User> selectManyByName(String name);
    List<User> selectUserByPage(Page page);
    void deleteUserById(int id);
    void insertUser(User user);

    //一对一
    User selectUserAndUserInfo(int id);
    User selectUserAndUserInfo2(int id);
    //一对多
    List<User> selectUserAndOrder(int id);


    // ${}  #{} 使用场景
    List<User> test(@Param("name") String name);

    List<User> test2(@Param("name") String name);

}
