package dao;

import domain.QueryVo;
import domain.User;

import java.util.List;

public interface UserDao {
    //查询所有用户
    List<User> findAll();

    //根据id查询用户信息
    User findById(Integer userId);

    //根据名称模糊查询用户信息
    List<User> findByName(String string);

    //查询总用户数
    int findTotal();

    //根据传入的参数条件查询
    List<User> findUserByCondition(User user);

    //根据queryvo中提供的id集合，查询用户信息
    List<User> findUserByInIds(QueryVo vo);
}
