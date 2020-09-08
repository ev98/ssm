package dao;

import domain.Account;
import domain.AccountUser;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    //查询所有有账户同时包含用户名和地址信息
    List<AccountUser> findAllAccount();
}
