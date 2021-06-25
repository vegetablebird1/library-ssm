package com.library.controller;

import com.library.pojo.Books;
import com.library.pojo.BorrowList;
import com.library.service.BookService;
import com.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService ;

    @Autowired
    @Qualifier("borrowServiceImpl")
    private BorrowService borrowService;

    //显示所有书籍
    @RequestMapping("/allBook")
    public String showAllBook(Model model){
        List<Books> booksList = bookService.queryAllBook();
        model.addAttribute("bookList_Borrow",booksList);
        return "allBook_Borrow";
    }

    //展示借书情况
    @RequestMapping("/showBorrow")
    public String showBorrow(Model model){
        List<BorrowList> list = borrowService.showBorrowList();
        model.addAttribute("borrowList",list);
        return "borrowList";
    }

    //查找图书馆里的书
    @RequestMapping("/queryBook")
    public String queryBook(Model model,String bookName){
        List<Books> booksList;
        booksList = bookService.queryBookByName(bookName);
        if(booksList.isEmpty()){
            model.addAttribute("error","未查到");
            return "allBook_Borrow";
        }
        model.addAttribute("bookList_Borrow",booksList);
        return "allBook_Borrow";
    }


    //借书
    @RequestMapping("/borrowBook")
    public String borrowBook(String username,String bookName,Integer num){
        borrowService.borrowBook(bookName);
        borrowService.borrowBookUpdate(username,bookName,num);
        return "redirect:/borrow/allBook";
    }

    //还书，还书后跳到借书详情页面
    @RequestMapping("/returnBook")
    public String returnBook(String bookName,Integer borrow_id,Integer num){
        borrowService.returnBook(num,bookName);
        borrowService.returnBookUpdate(borrow_id);
        return "redirect:/borrow/showBorrow";
    }

}
