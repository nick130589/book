package com.example.entity;


import java.sql.Date;

public class BorrowReturn {
    private String bookId;
    private Date borrowTime;
    private String fullname;
    private int bookStatus;
    private Date returnTime;
    private Date dueTime;

    public BorrowReturn(String bookId, Date borrowTime, String fullname, int bookStatus, Date returnTime, Date dueTime) {
        this.bookId = bookId;
        this.borrowTime = borrowTime;
        this.fullname = fullname;
        this.bookStatus = bookStatus;
        this.returnTime = returnTime;
        this.dueTime = dueTime;
    }

    public int getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(int bookStatus) {
        this.bookStatus = bookStatus;
    }

    public BorrowReturn() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }





    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }
}
