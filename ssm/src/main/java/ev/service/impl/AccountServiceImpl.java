package ev.service.impl;

import ev.dao.AccountDao;
import ev.domain.Account;
import ev.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }
}
