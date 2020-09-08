package service.impl;

import service.IAccountService;

import java.util.Date;


public class AccountServiceImpl2 implements IAccountService {

    private String name;
    private Integer age;
    private Date time;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了。。。" + name + "," + age + "," + time);
    }

}
