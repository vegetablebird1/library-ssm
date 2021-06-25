package com.library.service.impl;

import com.library.dao.BorrowMapper;
import com.library.pojo.BorrowList;
import com.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;

    public void setBorrowMapper(BorrowMapper borrowMapper) {
        this.borrowMapper = borrowMapper;
    }

    @Transactional
    @Override
    public int borrowBook(String bookName) {
        return borrowMapper.borrowBook(bookName);
    }

    @Transactional
    @Override
    public int borrowBookUpdate(String username,String bookName,Integer number){
        return borrowMapper.borrowBookUpdate(username,bookName,number);
    }

    @Override
    @Transactional
    public void returnBookUpdate(Integer borrow_id) {
        borrowMapper.returnBookUpdate(borrow_id);
    }

    @Transactional
    @Override
    public void returnBook(Integer number,String bookName) {
        borrowMapper.returnBook(number,bookName);
    }

    @Override
    public List<BorrowList> showBorrowList() {
        return borrowMapper.showBorrowList();
    }
}
