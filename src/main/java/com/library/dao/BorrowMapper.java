package com.library.dao;

import com.library.pojo.BorrowList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BorrowMapper {
    int borrowBook(@Param("bookName") String bookName);

    int borrowBookUpdate(@Param("username") String username,@Param("bookName") String bookName,@Param("number") Integer number);

    void returnBook(@Param("number") Integer number, @Param("bookName") String bookName);

    void returnBookUpdate(@Param("borrow_id") Integer borrow_id);

    List<BorrowList> showBorrowList();
}
