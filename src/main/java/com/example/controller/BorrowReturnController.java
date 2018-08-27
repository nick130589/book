package com.example.controller;

import com.example.dao.BorrowReturnDao;
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

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class BorrowReturnController {

    @Autowired
    private UserService userService;

    @Autowired
    private BorrowReturnService borrowReturnService;

    @Autowired
    private BookService bookService;
    //跳到登记页面
    @RequestMapping(value = "/user_borrow")
    public String user_borrow(){
        return "user_borrow";
    }
    //跳到归还页面
    @RequestMapping(value = "/user_return")
    public String user_return(){
        return "user_return";
    }

     //用户显示现有的记录
    @RequestMapping(value = "/user_history",method = RequestMethod.GET)
     public  String history(HttpSession session,Model model){

        User user =userService.selectUser((String)session.getAttribute("name"));
        String fullname=user.getFullname();
        System.out.println(fullname+"--在BorrowReturnController层");
        List<BorrowReturn> list=borrowReturnService.selectFullname(fullname);
        model.addAttribute("list",list);
         return "user_history";
     }


    //用户增加借书记录,跳到显示页
    @RequestMapping(value = "/user_borrow" ,method = RequestMethod.POST)
    public String add(
            @RequestParam("bookId") String bookId,
            @RequestParam("borrowTime") String borrowTime,
            @RequestParam("fullname") String fullname,HttpSession session,
            Model model
    ){
        System.out.println("\n日期："+borrowTime+"--在BorrowReturnController层");
          int status=1;

        //判断是否有该图书信息
        Book  book=null;
         book=bookService.selectBook(bookId);
        if(book==null)
        {
            model.addAttribute(("error"),"图书信息错误");
            return "user_borrow";
        }
        else{
        try {
            //日期格式装转换
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
            Date date=sdf.parse(borrowTime);

            //计算截止日期
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE,30);
            Date dueTime=calendar.getTime();

            java.sql.Date dateTime = new java.sql.Date(date.getTime());
            java.sql.Date dateTime2 = new java.sql.Date(dueTime.getTime());
            //创建一个插入的对象
            BorrowReturn borrowReturn=new BorrowReturn(bookId,dateTime,fullname,status,null,dateTime2);
            String res= borrowReturnService.addRecord(borrowReturn);
            if(res.equals("success"))
            {
                //返回历史纪录，查看所有借阅的信息包括刚刚借阅的
                List<BorrowReturn> list=borrowReturnService.selectFullname(fullname);
                model.addAttribute("list",list);
                return "user_history";
            }
        } catch (ParseException e) {
            e.printStackTrace();
            model.addAttribute(("error"),"借阅失败日期格式异常");
            return "user_borrow";
        }
            System.out.println("借书抛出异常--在BorrowReturnController层");
        model.addAttribute(("error"),"借阅失败");
        return "user_borrow";
       }
     }


     //用户还书登记，跳到显示页
    @RequestMapping(value="/user_return",method = RequestMethod.POST)
    public String return1(
            @RequestParam("bookId") String bookId,
            @RequestParam("fullname") String fullname,
            @RequestParam("returnTime") String returnTime,Model model){

        System.out.println("\n日期："+returnTime+"--在BorrowReturnController层");
        Book  book=null;
        book=bookService.selectBook(bookId);
        if(book==null)
        {
            model.addAttribute("error","图书信息错误");
            return "user_return";
        }
        else{
            //日期格式装转换
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
            try {
                Date date=sdf.parse(returnTime);
                java.sql.Date re=new java.sql.Date(date.getTime());
                //改变状态
                int status=0;
                BorrowReturn borrowReturn=new BorrowReturn(bookId,null,fullname,status,re,null);

                String res=borrowReturnService.changeStatus(borrowReturn);
                if(res.equals("success"))
                {
                    List<BorrowReturn> list=borrowReturnService.selectFullname(fullname);
                    model.addAttribute("list",list);
                    return "user_history";
                }
                else
                {
                    System.out.println("还书失败--在BorrowReturnController层");
                    model.addAttribute("error","修改status失败");
                    return "user_return";
                }

            } catch (ParseException e) {
                e.printStackTrace();
                model.addAttribute("error","归还失败日期格式异常");
                return "user_return";
            }
        }
    }

    //用户模糊查询_bookId
    @RequestMapping(value = "/user_history_by_bookId",method =RequestMethod.GET)
    public String select(@RequestParam("bookId") String bookId,Model model){
                List<BorrowReturn> list=borrowReturnService.selectByBookId(bookId);
                model.addAttribute("list",list);
                return "user_history";
    }

    //用户直接查询_status
    @RequestMapping(value = "/user_history_by_status",method =RequestMethod.GET)
    public String select_by_status(@RequestParam("status") String status,Model model){
        if(status.equals("未还"))
        {
        List<BorrowReturn> list=borrowReturnService.selectByStatus(1);
            model.addAttribute("list",list);
        }
        else{
            List<BorrowReturn> list=borrowReturnService.selectByStatus(0);
            model.addAttribute("list",list);
        }

        return "user_history";
    }

    //用户续借
    @RequestMapping(value = "/renew",method =RequestMethod.GET)
    public String renew(@RequestParam("bookId") String bookId,
                        @RequestParam("fullname") String fullname,
                        Model model){
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE,date.get(Calendar.DATE));
        Date today = date.getTime();// today即为当前时间
        java.sql.Date borrowTime=new java.sql.Date(today.getTime());
        BorrowReturn borrowReturn=new BorrowReturn(bookId,borrowTime,fullname,1,null,null);
        String res=borrowReturnService.update(borrowReturn);
        List<BorrowReturn> list=borrowReturnService.selectFullname(fullname);
        model.addAttribute("list",list);
        return "user_history";
    }
    //______________________________________________________________________管理员————————————————————————————————
}
