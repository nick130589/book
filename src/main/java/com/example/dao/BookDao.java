package com.example.dao;

import com.example.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao  {
    /**
     * 查询单本图书信息
     * @param bookId
     */
    public Book selectBook(String bookId);

    /**
     * 查询所有图书信息
     */
    public List<Book> selectAllBook();

    /**
     *根据书名查图书
     * @param bookName
     */
    public List<Book> selectByBookName(String bookName);

    /**
     * 根据作者查图书
     * @param author
     */
    public List<Book> selectByAuthor(String author);

    public List<Book> selectById(String bookId);
    /**
     * 添加图书信息
     * @param book
     */
    public void addBook(Book book);

    /**
     * 删除图书
     * @param bookId
     */
    public void deleteBook(String bookId);


}
