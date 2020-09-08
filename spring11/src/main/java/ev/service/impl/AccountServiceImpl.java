package ev.service.impl;

import ev.dao.IAccountDao;
import ev.domain.Account;
import ev.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true) //只读型事务的配置
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false) //读写型事务的配置
    @Override
    public void transfer(String sourceName, String targetName, float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
        //int i = 1/0;
        accountDao.updateAccount(target);
    }
}
