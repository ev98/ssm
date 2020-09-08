package ev.service.impl;

import ev.dao.IAccountDao;
import ev.domain.Account;
import ev.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
        int i = 1/0;
        accountDao.updateAccount(target);
    }
}
