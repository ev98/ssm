package ev.dao;

import ev.domain.Info;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoDao {

    @Select("select * from info where username = #{username} and password = #{password}")
    Info findInfoByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
