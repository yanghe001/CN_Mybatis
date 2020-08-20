package run;
import dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import page.Page;
import pojo.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 使用 Dao 进行相应操作
 * 简单操作
 */
public class TestDaoRun {
    private static SqlSession sqlSession=null;
    private static String config="mybatis/config.xml";

    //创建 sqlSession 对象
    static {
        InputStream inputStream= null;
        try {
            inputStream = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession();
    }

    public static void main(String[] args) {
        test2();
    }

    /**
     * ${}  #{} 操作使用
     */
    public static void test(){
        System.out.println("select * from user order by id ${name}");
        UserDao userDao= sqlSession.getMapper(UserDao.class);
        List<User> userList=userDao.test("desc");
        userList.forEach(user -> System.out.println(user));
    }
    public static void test2(){
        System.out.println(" select  * from ${name}");
        UserDao userDao= sqlSession.getMapper(UserDao.class);
        List<User> userList=userDao.test2("user");
        userList.forEach(user -> System.out.println(user));
    }
    /**
     * 一对多
     * @param user_id
     */
    public static void findUserAndOrder(int user_id){
        System.out.println("一对多");
        UserDao userDao= sqlSession.getMapper(UserDao.class);
        List<User> userOrders=userDao.selectUserAndOrder(user_id);
        userOrders.forEach(u -> System.out.println(u));
    }
    /**
     * 一对一
     * @param user_id
     */
    public  static void findUserAndUserInfo(int user_id){
        System.out.println("一对一");
        UserDao userDao= sqlSession.getMapper(UserDao.class);
        User user=userDao.selectUserAndUserInfo(user_id);
        System.out.println(user);
    }
    public  static void findUserAndUserInfo2(int user_id){
        System.out.println("一对一");
        UserDao userDao= sqlSession.getMapper(UserDao.class);
        User user=userDao.selectUserAndUserInfo2(user_id);
        System.out.println(user);
    }
    /**
     * 添加用户 并且获取到自增的 id
     */
    public static void insertUser(){
        User user = new User();
        user.setName("小小");
        user.setAge(30);
        UserDao userDao=sqlSession.getMapper(UserDao.class);
        userDao.insertUser(user);
        System.out.println(user.getId());
    }
    /**
     * 根据用户id删除用户
     * @param id
     */
    public static void deleteUserById(int id){
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.deleteUserById(id);
    }
    /**
     * 简单分页
     */
    public static void findUserByPage(){
        Page page = new Page();
        page.setPageNum(1);
        page.setPageSize(3);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList=userDao.selectUserByPage(page);
        userList.forEach(u -> System.out.println(u));
    }
    /**
     * 模糊查询
     * @param name
     */
    public static void findManyByName(String  name){
        System.out.println("根据名字模糊查询用户信息");
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList=userDao.selectManyByName(name);
        userList.forEach(u -> System.out.println(u));
    }
    /**
     * 查询所有用户
     */
    public static void findAll(){
        System.out.println("查询所有用户信息");
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList=userDao.selectAll();
        userList.forEach(u -> System.out.println(u));
    }
    /**
     * 查询一个用户信息
     * @param id
     */
    public static void findOne(int id){
        System.out.println("根据id查询用户信息");
        UserDao userDao =  sqlSession.getMapper(UserDao.class);
        System.out.println(userDao.selectOne(id));
    }
}
