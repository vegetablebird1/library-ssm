package com.library.service;

import com.library.pojo.Books;

import java.util.List;

public interface BookService {
    int addBook(Books books);

    int deleteBook(Integer id);

    int updateBook(Books books);

    Books queryBookById(Integer id);

    List<Books> queryAllBook();

    List<Books> queryBookByName(String bookName);
}
