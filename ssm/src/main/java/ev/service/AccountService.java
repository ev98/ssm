package ev.service;

import ev.domain.Account;

import java.util.List;

public interface AccountService {
    //查询所有
    public List<Account> findAll();

    //保存账户信息
    public void saveAccount(Account account);
}
