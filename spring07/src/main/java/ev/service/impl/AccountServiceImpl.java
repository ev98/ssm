package ev.service.impl;

import ev.service.AccountService;

//业务层实现类
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("执行了保存。。。");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新。。。");
    }

    public int deleteAccount() {
        System.out.println("执行了删除。。。");
        return 0;
    }
}
