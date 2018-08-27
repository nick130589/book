package com.example.dao;

import com.example.entity.BorrowReturn;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowReturnDao {
    public void addRecord(BorrowReturn borrowReturn);

    public void deleteRecord(BorrowReturn borrowReturn);

    public List<BorrowReturn> selectAll();

    /**
     * 根据书的ID模糊查询
     * @param bookId
     * @return
     */
    public List<BorrowReturn> selectByBookId(String bookId);

    /**
     * 根据状态直接查询
     * @param status
     * @return
     */
    public  List<BorrowReturn> selectByStatus(int status);

    public List<BorrowReturn> selectFullname(String fullname);

    public  void changeStatus(BorrowReturn borrowReturn);

    /**
     * 根据书名模糊查询
     * @param bookName
     * @return
     */
    public List<BorrowReturn> selectByBookName(String bookName);

    /**
     * 根据学号模糊查询
     * @param studentId
     * @return
     */
    public List<BorrowReturn> selectByStudentId(String studentId);

    /**
     * 续借修改借阅时间
     * @param borrowReturn
     */
    public void update(BorrowReturn borrowReturn);
}
