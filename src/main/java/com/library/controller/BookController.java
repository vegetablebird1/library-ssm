package com.library.controller;

import com.library.pojo.Books;
import com.library.pojo.BorrowList;
import com.library.service.BookService;
import com.library.service.BorrowService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @Autowired
    @Qualifier("borrowServiceImpl")
    private BorrowService borrowService;

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> booksList = bookService.queryAllBook();
        model.addAttribute("bookList",booksList);
        return  "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook->" + books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(Integer bookID,Model model){
        Books books = bookService.queryBookById(bookID);
        model.addAttribute("QBook",books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@Param("bookID") Integer bookID){
        bookService.deleteBook(bookID);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(Model model,String bookName){
        List<Books> booksList = bookService.queryBookByName(bookName);
        if(booksList.isEmpty()){
            model.addAttribute("error","未查到");
            return "allBook";
        }
        model.addAttribute("bookList",booksList);
        return "allBook";
    }

    @RequestMapping("/showBorrow")
    public String showBorrow(Model model){
        List<BorrowList> borrowLists = borrowService.showBorrowList();
        model.addAttribute("borrowLists",borrowLists);
        return "/showBorrowList";
    }
}
