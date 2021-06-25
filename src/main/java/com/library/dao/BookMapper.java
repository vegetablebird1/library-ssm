package com.library.dao;

import com.library.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int addBook(Books books);

    int deleteBook(@Param("bookID") Integer id);

    int updateBook(Books books);

    Books queryBookById(@Param("bookID") Integer id);

    List<Books> queryAllBook();

    List<Books> queryBookByName(String bookName);
}
