package test;

import config.SpringConfiguration;
import ev.domain.Account;
import ev.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/*
* Spring整合junit的配置
*   1.导入spring整合junit的jar
*   2.使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
*       @RunWith
*   3.告知spring的运行器，spring和ioc创建是基于xml注解的，并且说明位置
*       @ContextConfiguration
*           locations：指定xml文件的位置，加上classpath关键字，表示再类路径下
*           classes：指定注解类所在位置
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    /*private ApplicationContext ac;
    private AccountService as;
    @Before
    public void init(){
        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        as = ac.getBean("accountService", AccountService.class);
    }*/

    @Autowired
    private AccountService as;

    @Test
    public void testFindAll() {
        /*//ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService as = ac.getBean("accountService", AccountService.class);*/

        List<Account> accounts = as.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindById() {
        Account account = as.findById(1);
        System.out.println(account);
    }

    @Test
    public void testAdd() {
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(123);
        as.addAccount(account);
    }

    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(4);
        account.setMoney(1234);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        as.deleteAccount(4);
    }
}
