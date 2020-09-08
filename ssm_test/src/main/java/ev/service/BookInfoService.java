package ev.service;

import ev.domain.BookInfo;

import java.util.List;

public interface BookInfoService {

    List<BookInfo> findAll();

    void addBookInfo(BookInfo bookInfo);

    void updateBookInfo(BookInfo bookInfo);

    void deleteBookInfo(Integer id);

    BookInfo findById(Integer id);

}
