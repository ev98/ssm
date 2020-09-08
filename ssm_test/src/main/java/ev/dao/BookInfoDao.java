package ev.dao;

import ev.domain.BookInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookInfoDao {

    @Select("select * from bookinfo")
    List<BookInfo> findAll();

    @Insert("insert into bookinfo (bookname,author,intro) values (#{bookname},#{author},#{intro})")
    void addBookInfo(BookInfo bookInfo);

    @Update("update bookinfo set bookname=#{bookname},author=#{author},intro=#{intro} where id=#{id}")
    void updateBookInfo(BookInfo bookInfo);

    @Delete("delete from bookinfo where id = #{id}")
    void deleteBookInfo(Integer id);

    @Select("select * from bookinfo where id=#{id}")
    BookInfo findById(Integer id);

}
