package test;

import ev.dao.AccountDao;
import ev.domain.Account;
import ev.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestSpring {

    @Test
    public void run1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService as = ac.getBean("accountService", AccountService.class);
        as.findAll();
    }

    /*@Test
    public void run2() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建session对象
        SqlSession session = factory.openSession();

        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有数据
        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }

        //关闭资源
        session.close();
        in.close();
    }

    @Test
    public void run3() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建session对象
        SqlSession session = factory.openSession();

        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //添加
        Account account = new Account();
        account.setName("ccc");
        account.setMoney(2000d);
        dao.saveAccount(account);

        //关闭资源
        session.commit();
        session.close();
        in.close();
    }*/
}
