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

public class MybatisTest {
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
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("ev");
        user.setAddress("漯河");
        user.setSex("男");
        user.setBirthday(new Date());

        //5.执行保存方法
        System.out.println("保存操作之前"+user);
        userDao.saveUser(user);
        System.out.println("保存操作之后"+user);
        //提交事务
        sqlSession.commit();
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(50);
        user.setUsername("赵一玮");
        user.setAddress("漯河");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(51);
    }

    @Test
    public void testFindById() {
        User user = userDao.findById(50);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName("%王%");
        //List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int count = userDao.findTotal();
        System.out.println(count);
    }
}
