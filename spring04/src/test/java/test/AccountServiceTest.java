package test;

import ev.dao.AccountDao;
import ev.domain.Account;
import ev.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.SpringConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration(classes = SpringConfiguration.class)*/
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private AccountService as;

    @Test
    public void testFindAll() {
        /*ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = ac.getBean("accountService", AccountService.class);*/


        List<Account> accounts = as.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindById() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = ac.getBean("accountService", AccountService.class);

        Account account = as.findById(1);
        System.out.println(account);
    }

    @Test
    public void testAdd() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = ac.getBean("accountService", AccountService.class);

        Account account = new Account();
        account.setName("ddd");
        account.setMoney(123);
        as.addAccount(account);
    }

    @Test
    public void testUpdate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = ac.getBean("accountService", AccountService.class);

        Account account = new Account();
        account.setId(4);
        account.setMoney(1234);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = ac.getBean("accountService", AccountService.class);

        as.deleteAccount(4);
    }

    @Test
    public void testTransfer(){
        as.transfer("aaa","bbb",100f);
    }
}
