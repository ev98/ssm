package dao;

import domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@CacheNamespace(blocking = true)
public interface UserDao {
    //查询所有用户
    @Select("select * from user")
    @Results(id="userMap",value = {
            @Result(id = true,column = "id", property = "userId"),
            @Result(column = "username", property = "userName"),
            @Result(column = "address", property = "userAddress"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "birthday", property = "userBirthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "dao.AccountDao.findAccountByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    //添加用户
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void addUser(User user);

    //修改用户
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id} ")
    void updateUser(User user);

    //删除用户
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);

    //根据id查询用户
    @Select("select * from user where id=#{id}")
    @ResultMap(value = {"userMap"})
    User findById(Integer id);

    //根据用户名模糊查询
    //@Select("select * from user where username like #{username}")
    @Select("select * from user where username like '%${value}%' ")
    List<User> findUserByName(String username);

    //查询用户总量
    @Select("select count(id) from user")
    int findTotalUser();
}
