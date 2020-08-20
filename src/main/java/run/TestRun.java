package run;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 使用 SqlSession 进行相应操作
 * 简单的操作
 */
public class TestRun {

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
        //加载构建 SqlSessionFactory 实例
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        //创建 sqlSession 对象实例
        sqlSession = factory.openSession();
    }
    public static void main(String[] args) {
        findOne(1);
        findAll();
        sqlSession.close();
    }

    public static void findOne(int id){
        System.out.println("根据id查询用户信息");
        User user=sqlSession.selectOne("selectOne",id);
        System.out.println(user);
    }
    public static void findAll(){
        System.out.println("查询所有用户信息");
        List<User> userList = sqlSession.selectList("selectAll");
        userList.forEach(u -> System.out.println(u));
    }


}
