package com.example.service;

import com.example.dao.BookDao;
import com.example.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookService {
    @Autowired
    BookDao bookDao;

    /**
     * 查询单本图书信息
     * @param bookId
     */
    public Book selectBook(String bookId){
        return  bookDao.selectBook(bookId);
    }

    /**
     * 查询所有图书信息
     */
    public List<Book> selectAllBook(){
        return bookDao.selectAllBook();
    }

    /**
     *根据书名查图书
     * @param bookName
     */
    public List<Book> selectByBookName(String bookName){
        bookName="%"+bookName+"%";
        System.out.println(bookName+"根据作者模糊查，在BookService");
        return bookDao.selectByBookName(bookName);
    }

    /**
     * 根据作者查图书
     * @param author
     */
    public List<Book> selectByAuthor(String author){
        author="%"+author+"%";
        System.out.println(author+"根据作者模糊查，在BookService");
        return bookDao.selectByAuthor(author);
    }

    public List<Book> selectById(String bookId){
        bookId="%"+bookId+"%";
        System.out.println(bookId+"根据Id查模糊，在BookService");
        return bookDao.selectById(bookId);
    }

    /**
     * 添加图书信息
     * @param book
     */
    public String  addBook(Book book){
        bookDao.addBook(book);
        return "success";
    }

    /**
     * 删除图书
     * @param bookId
     */
    public String deleteBook(String bookId){
        try{
            bookDao.deleteBook(bookId);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }
}