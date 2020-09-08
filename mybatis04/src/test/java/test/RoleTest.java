package test;

import dao.RoleDao;
import dao.UserDao;
import domain.Role;
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

public class RoleTest {
    private InputStream in;
    private SqlSession sqlSession;
    private RoleDao roleDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        roleDao = sqlSession.getMapper(RoleDao.class);
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
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }

}
