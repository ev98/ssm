package ev.dao.impl;

import ev.dao.AccountDao;
import ev.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner runner;


    public List<Account> findAll() {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findById(Integer id) {
        try {
            return runner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addAccount(Account account) {
        try {
            runner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("update account set name=?,money=? where id = ? ",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer id) {
        try {
            runner.update("delete from account where id = ?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByName(String name) {
        try {
            List<Account> accounts = runner.query("select * from account where name = ?", new BeanListHandler<Account>(Account.class), name);
            if (accounts == null || accounts.size() == 0){
                return null;
            }else if(accounts.size() > 1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }else {
                return accounts.get(0);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
