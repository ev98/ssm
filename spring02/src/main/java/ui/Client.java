package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IAccountService;


public class Client {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
       IAccountService as  = (IAccountService)ac.getBean("accountService");
        as.saveAccount();

        IAccountService as2 = (IAccountService) ac.getBean("accountService2");
        as2.saveAccount();

        IAccountService as3 = (IAccountService) ac.getBean("accountService3");
        as3.saveAccount();
    }
}
