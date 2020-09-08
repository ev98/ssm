package ev.dao;

import ev.domain.Account;

import java.util.List;

public interface AccountDao {
    //查询所有
    List<Account> findAll();

    //查询一个
    Account findById(Integer id);

    //添加
    void addAccount(Account account);

    //修改
    void updateAccount(Account account);

    //删除
    void deleteAccount(Integer id);
}
