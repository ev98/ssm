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
    private AccountDao dao;


    public List<Account> findAll() {
        return dao.findAll();
    }

    public Account findById(Integer id) {
        return dao.findById(id);
    }

    public void addAccount(Account account) {
        dao.addAccount(account);
    }

    public void updateAccount(Account account) {
        dao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {
        dao.deleteAccount(id);
    }
}
