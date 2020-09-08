package test;

import dao.UserDao;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();  //sqlSession = factory.openSession(true);
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void testFindAll2(){
        List<User> users = userDao.findAll2();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

}
