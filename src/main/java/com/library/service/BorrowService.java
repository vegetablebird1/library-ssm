package com.library.service;

import com.library.pojo.BorrowList;

import java.util.List;

public interface BorrowService {
    int borrowBook(String bookName);

    int borrowBookUpdate(String username,String bookName,Integer number);

    void returnBook(Integer number,String bookName);

    void returnBookUpdate(Integer borrow_id);

    List<BorrowList> showBorrowList();
}
