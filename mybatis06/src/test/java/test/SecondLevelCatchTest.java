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

public class SecondLevelCatchTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }
    @After
    public void destroy() throws IOException {

        in.close();
    }

    @Test
    public void findById(){
        User user = userDao.findById(50);
        System.out.println(user);
        sqlSession.close();//释放一级缓存

        sqlSession = factory.openSession(); //再次打开session
        userDao = sqlSession.getMapper(UserDao.class);
        User user2 = userDao.findById(50);
        System.out.println(user2);

        System.out.println(user==user2);

    }
}
