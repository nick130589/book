package com.example.entity;

import java.sql.Date;

public class Book {
    private  String bookId;
    private  String bookName;
    private String author;
    private  String publishHouse;
    private Date publishTime;
    private String remain;
    private  Date addTime;

    public Book(String bookId, String bookName, String author, String publishHouse, Date publishTime, String remain, Date addTime) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publishHouse = publishHouse;
        this.publishTime = publishTime;
        this.remain = remain;
        this.addTime = addTime;
    }
    public Book(){
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishHouse() {
        return publishHouse;
    }

    public void setPublishHouse(String publishHouse) {
        this.publishHouse = publishHouse;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
