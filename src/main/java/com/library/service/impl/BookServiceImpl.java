package com.library.service.impl;

import com.library.dao.BookMapper;
import com.library.pojo.Books;
import com.library.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    //调用dao
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Transactional
    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Transactional
    @Override
    public int deleteBook(Integer id) {
        return bookMapper.deleteBook(id);
    }

    @Transactional
    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(Integer id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public List<Books> queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }


}
