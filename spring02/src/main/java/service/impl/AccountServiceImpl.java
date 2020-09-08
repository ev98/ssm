package service.impl;

import service.IAccountService;

import java.util.Date;


public class AccountServiceImpl implements IAccountService {

    private String name;
    private Integer age;
    private Date time;

    public AccountServiceImpl(String name, Integer age, Date time) {
        this.name = name;
        this.age = age;
        this.time = time;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了。。。" + name + "," + age + "," + time);
    }

}
