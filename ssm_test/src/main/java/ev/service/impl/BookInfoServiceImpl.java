package ev.service.impl;

import ev.dao.BookInfoDao;
import ev.domain.BookInfo;
import ev.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookInfoService")
public class BookInfoServiceImpl implements BookInfoService {

    @Autowired
    private BookInfoDao bookInfoDao;

    @Override
    public List<BookInfo> findAll() {
        return bookInfoDao.findAll();
    }

    @Override
    public void addBookInfo(BookInfo bookInfo) {
        bookInfoDao.addBookInfo(bookInfo);
    }

    @Override
    public void updateBookInfo(BookInfo bookInfo) {
        bookInfoDao.updateBookInfo(bookInfo);
    }

    @Override
    public void deleteBookInfo(Integer id) {
        bookInfoDao.deleteBookInfo(id);
    }

    @Override
    public BookInfo findById(Integer id) {
        return bookInfoDao.findById(id);
    }
}
