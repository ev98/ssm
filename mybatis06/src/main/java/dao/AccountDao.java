package dao;

import domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {

    //查询所有账户，并且获得每个账户的用户信息
    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one = @One(select = "dao.UserDao.findById",fetchType = FetchType.EAGER)),
    })
    List<Account> findAll();

    @Select("select * from account where uid = #{userId}")
    List<Account> findAccountByUid(int userId);
}
