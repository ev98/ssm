package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    //查询所有用户
    List<User> findAll();

    //多对多查询所有
    List<User> findAll2();
}
