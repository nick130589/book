package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    //用户查询得到所有图书信息，Get
    @RequestMapping(value = "/user_query",method = RequestMethod.GET)
    public String user_query(Model model){
        List<Book> list=bookService.selectAllBook();
        model.addAttribute("list",list);
        return "user_query";
    }

    //用户查看图书详情，get -bookId
    @RequestMapping(value = "/user_book_message" ,method = RequestMethod.GET)
    public String user_book_message(@RequestParam(value = "bookId") String bookId, Model model){
        System.out.println("在bookController里面bookId--"+bookId);
        Book book=bookService.selectBook(bookId);
        System.out.println("在bookController里面返回的Book对象--"+book.getBookId());
        model.addAttribute("book",book);
        return "user_book_message";
    }

    //用户根据图书标号查图书，get -bookId   根据bookId查找的是唯一的
    @RequestMapping(value = "/user_query_by_bookId" ,method = RequestMethod.GET)
    public String user_query_by_bookId(@RequestParam("bookId")  String bookId ,Model model){
        List<Book> list=bookService.selectById(bookId);
        model.addAttribute("list",list);
        return "user_query";
    }

    //用户根据作者查图书,get -author
    @RequestMapping(value = "/user_query_by_author" ,method = RequestMethod.GET)
    public String user_query_by_author(@RequestParam("author") String author ,Model model){
        System.out.println(author+"根据作者查，在userController");
        List<Book> list=bookService.selectByAuthor(author);
        model.addAttribute("list",list);
        return "user_query";
    }

    //用户根据书名查图书,get -bookName
    @RequestMapping(value = "/user_query_by_bookName",method = RequestMethod.GET)
    public String user_query_by_bookName(@RequestParam("bookName") String bookName ,Model model){
        List<Book> list=bookService.selectByBookName(bookName);
        model.addAttribute("list",list);
        return "user_query";
    }
    //-------------------------------------------------------------管理员-----------------------------------------------------------------------------
    //管理员 查询得到所有图书信息，get
    @RequestMapping(value = "/admin_query",method = RequestMethod.GET)
    public String admin_query(Model model){
        List<Book> list=bookService.selectAllBook();
        model.addAttribute("list",list);
        return "admin_query";
    }

    //管理员查看图书详情，get -bookId
    @RequestMapping(value = "/admin_book_message" ,method = RequestMethod.GET)
    public String admin_book_message(String bookId,Model model){
        Book book=bookService.selectBook(bookId);
        model.addAttribute("book",book);
        return "admin_book_message";
    }

    //管理员根据作者查看图书，get -auther
    @RequestMapping(value = "/admin_query_by_author")
    public String admin_query_by_author(String author ,Model model){
        List<Book> list=bookService.selectByAuthor(author);
        model.addAttribute("list",list);
        return "admin_query";
    }

    //管理员根据图书标号查图书，get -bookId   根据bookId查找的是唯一的
    @RequestMapping(value = "/admin_query_by_bookId" ,method = RequestMethod.GET)
    public String admin_query_by_bookId(String bookId ,Model model){
        List<Book> list=null;
        Book book=bookService.selectBook(bookId);
        list.add(book);
        model.addAttribute("list",list);
        return "admin_query";
    }

    //管理员根据书名查图书,get -bookName
    @RequestMapping(value = "/admin_query_by_bookName",method = RequestMethod.GET)
    public String admin_query_by_bookName(String bookName ,Model model){
        List<Book> list=bookService.selectByBookName(bookName);
        model.addAttribute("list",list);
        return "admin_query";
    }

    //管理员进入添加图书界面，post ,book
    @RequestMapping(value = "admin_book_add",method = RequestMethod.GET)
    public String admin_book_add(){

        return "admin_book_add";
    }

    @RequestMapping(value = "admin_book_add",method = RequestMethod.POST)
    public String admin_book_add(
            @RequestParam("bookId") String bookId,
            @RequestParam("bookName") String bookName,
            @RequestParam("author") String author,
            @RequestParam("publishHouse") String publishHouse,
            @RequestParam("publishTime") String publishTime,
            @RequestParam("remain") String remain,
            Model model
    ){
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE,date.get(Calendar.DATE));
        Date today = date.getTime();// today即为当前时间
        java.sql.Date addTime=new java.sql.Date(today.getTime());
        try {
            Date endTime=dft.parse(publishTime);
            java.sql.Date publish=new java.sql.Date(endTime.getTime());
            Book book=new Book(bookId,bookName, author,publishHouse,publish,remain,addTime);
            System.out.println("add in BookController");
            bookService.addBook(book);
            List<Book> list=bookService.selectAllBook();
            model.addAttribute("list",list);
            return "admin_query";
        } catch (ParseException e) {
            e.printStackTrace();
            List<Book> list=bookService.selectAllBook();
            model.addAttribute("list",list);
            return "admin_query";
        }

    }

    //管理员删除图书，post ,book ,
    @RequestMapping(value = "/book_delete",method = RequestMethod.GET)
    public String admin_book_add(@RequestParam("bookId") String bookId ,Model model){
        String res=bookService.deleteBook(bookId);
        List<Book> list=bookService.selectAllBook();
        model.addAttribute("list",list);
        return "admin_query";

    }



}
