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
        return  dao.findAll();
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

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
            //2.1.根据名称查询转出账户
            Account source = dao.findAccountByName(sourceName);
            //2.2.根据名称查询转入账户
            Account target = dao.findAccountByName(targetName);
            //2.3.转出账户减钱
            source.setMoney(source.getMoney()-money);
            //int i = 1/0;
            //2.4.装入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5.更新转出账户
            dao.updateAccount(source);
            //2.6.更新转入账户
            dao.updateAccount(target);
    }
}
