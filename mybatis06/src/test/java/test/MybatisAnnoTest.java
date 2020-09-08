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
import java.util.Date;
import java.util.List;

public class MybatisAnnoTest {
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
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

   /* @Test
    public void addUser(){
        User user = new User();
        user.setUsername("123");
        user.setAddress("aaa");
        userDao.addUser(user);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(53);
        user.setUsername("123");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }*/

    @Test
    public void deleteUser(){
        userDao.deleteUser(53);
    }

    @Test
    public void findById(){
        User user = userDao.findById(50);
        System.out.println(user);

        User user2 = userDao.findById(50);
        System.out.println(user2);

        System.out.println(user==user2);
    }

    @Test
    public void findByName(){
        //List<User> users = userDao.findUserByName("%王%");
        List<User> users = userDao.findUserByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findTotal(){
        System.out.println(userDao.findTotalUser());
    }
}
