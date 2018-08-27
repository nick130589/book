package com.example.controller;

import com.example.entity.Book;
import com.example.entity.BorrowReturn;
import com.example.entity.User;
import com.example.service.BookService;
import com.example.service.BorrowReturnService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    private BookService bookService;

    @Autowired
    private BorrowReturnService borrowReturnService;
    //访问主页
    @RequestMapping(value = "/admin_index",method = RequestMethod.GET)
    public String admin(){
        return "admin_index";
    }

    //查询所有用户
    @RequestMapping(value = "/admin_user",method = RequestMethod.GET)
    public String admin_user(Model model){
        List<User> list= userService.getUserList();
        model.addAttribute("list",list);
        return "admin_user";
    }

    @RequestMapping(value = "/user_delete",method = RequestMethod.GET)
    public String admin_user(@RequestParam("studentId") String studentId,Model model){
        String res=userService.deleteUser(studentId);
        if(res.equals("success")) {
            List<User> list = userService.getUserList();
            model.addAttribute("list", list);
        }
        else
        {
            List<User> list = userService.getUserList();
            model.addAttribute("list", list);
        }
        return "admin_user";
    }

    //得到状态不同的值的记录,未还
    @RequestMapping(value = "/admin_borrow",method = RequestMethod.GET)
    public String admin_borrow(Model model){
        System.out.println("\nselect in AdminController");
        List<BorrowReturn> list =borrowReturnService.selectByStatus(1);
        model.addAttribute("list",list);
          return "admin_borrow";
    }
    //已还
    @RequestMapping(value = "/admin_return",method = RequestMethod.GET)
    public String admin_return(Model model){
        List<BorrowReturn> list =borrowReturnService.selectByStatus(0);
        model.addAttribute("list",list);
        return "admin_return";
    }

    //记录删除
    @RequestMapping(value = "/borrow_delete",method = RequestMethod.GET)
    public String borrow_delete(@RequestParam("bookId") String bookId,
                                @RequestParam("fullname") String fullname,
                                Model model){
        BorrowReturn borrowReturn=new BorrowReturn(bookId,null,fullname,0,null,null);
        String res=borrowReturnService.deleteRecord(borrowReturn);
        List<BorrowReturn> list =borrowReturnService.selectByStatus(1);
        model.addAttribute("list",list);
        return "admin_borrow";
    }

    //记录删除
    @RequestMapping(value = "/return_delete",method = RequestMethod.GET)
    public String return_delete(@RequestParam("bookId") String bookId,
                                @RequestParam("fullname") String fullname,
                                Model model){
        BorrowReturn borrowReturn=new BorrowReturn(bookId,null,fullname,0,null,null);
        String res=borrowReturnService.deleteRecord(borrowReturn);
        List<BorrowReturn> list =borrowReturnService.selectByStatus(0);
        model.addAttribute("list",list);
        return "admin_return";
    }

}
