package com.example.service;

import com.example.dao.BorrowReturnDao;
import com.example.entity.BorrowReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("borrowReturnService")
public class BorrowReturnService {
    @Autowired
    private BorrowReturnDao borrowReturnDao;

    public String addRecord(BorrowReturn borrowReturn){
       try{ borrowReturnDao.addRecord(borrowReturn);
           System.out.println("\nji-添加成功：--在BorrowReturnService层");
           return "success";
       }
       catch (Exception e){
           System.out.println("\nji-添加失败：--在BorrowReturnService层");
           return "error";
       }
    }

    public String deleteRecord(BorrowReturn borrowReturn){
        try{ borrowReturnDao.deleteRecord(borrowReturn);
            return "success";
        }
        catch (Exception e){
            return "error";
        }
    }

    public List<BorrowReturn> selectAll(){
        return  borrowReturnDao.selectAll();
    }

    /**
     * 根据书的ID模糊查询
     * @param bookId
     * @return
     */
    public List<BorrowReturn> selectByBookId(String bookId){
        bookId="%"+bookId+"%";
        return borrowReturnDao.selectByBookId(bookId);
    }

    /**
     * 根据状态直接查询
     * @param status
     * @return
     */
    public  List<BorrowReturn> selectByStatus(int status){
        System.out.println("\nselect in BorrowReturnService");
        return borrowReturnDao.selectByStatus(status);
    }

    public List<BorrowReturn> selectFullname(String fullname){
        System.out.println(fullname+"--在BorrowReturnService层");
        return borrowReturnDao.selectFullname(fullname);
    }

    public  String changeStatus(BorrowReturn borrowReturn){
        try{ borrowReturnDao.changeStatus(borrowReturn);
            return "success";
        }
        catch (Exception e){
            System.out.println("还书失败--在BorrowReturnService层");
            return "error";
        }
    }

    /**
     * 根据书名模糊查询
     * @param bookName
     * @return
     */
    public List<BorrowReturn> selectByBookName(String bookName){
        return borrowReturnDao.selectByBookName(bookName);
    }

    /**
     * 根据学号模糊查询
     * @param studentId
     * @return
     */
    public List<BorrowReturn> selectByStudentId(String studentId){
        return borrowReturnDao.selectByStudentId(studentId);
    }

    public String update(BorrowReturn borrowReturn) {
        try {
            borrowReturnDao.update(borrowReturn);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
}
