package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    //查询所有用户
    List<User> findAll();

    //根据id查询用户信息
    User findById(Integer userId);
}
