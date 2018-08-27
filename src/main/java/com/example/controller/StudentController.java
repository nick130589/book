package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    //查询得到所有学生信息，Get
    @RequestMapping(value = "/student_admin_query", method = RequestMethod.GET)
    public String student_admin_query(Model model) {
        List<Student> list=studentService.selectAllStudent();
        model.addAttribute("list",list);
        return "student_admin_query";
    }

    //查询得到学生信息
    @RequestMapping(value = "/admin_student_message",method = RequestMethod.GET)
    public String admin_student_message(String studentID, Model model) {
        Student student = studentService.selectStudent(studentID);
        model.addAttribute("student", student);
        return "admin_student_message";
    }

    //根据人名查学生
    @RequestMapping(value = "/student_admin_query_by_name",method = RequestMethod.GET)
    public String student_admin_query_by_name(String realname, Model model) {
        List<Student> list = studentService.selectByName(realname);
        model.addAttribute("list", list);
        return "student_admin_query";
    }

    //根据用户名查
    @RequestMapping(value = "/student_admin_query_by_username", method = RequestMethod.GET)
    public String student_admin_query_by_username(String username, Model model) {
        List<Student> list = studentService.selectByUsername(username);
        model.addAttribute("list", list);
        return "student_admin_query";
    }

    //根据id查
    @RequestMapping(value = "/student_admin_query_by_studentID", method = RequestMethod.GET)
    public String student_admin_query_by_studentID(String studentID, Model model) {
        List<Student> list = studentService.selectByStudentID(studentID);
        model.addAttribute("list", list);
        return "student_admin_query";
    }

    //进入学生信息添加页面
    @RequestMapping(value = "admin_student_add", method = RequestMethod.GET)
    public String admin_student_add() {
        return "admin_student_add";
    }


    @RequestMapping(value = "admin_student_add", method = RequestMethod.POST)
    public String admin_student_add (
            @RequestParam("realname") String realname,
            @RequestParam("studentID") String studentID,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model
    )
    {
        Student student = new Student(realname, studentID, username, password);
        if (studentService.checkStudent(student)=="success") {
            System.out.println("add in StudentController");
            studentService.addStudent(student);
            List<Student> list = studentService.selectAllStudent();
            model.addAttribute("list", list);
            return "student_admin_query";
        }
        else if (studentService.checkStudent(student)=="username error") {
            model.addAttribute("error", "用户名已被注册");
            return "admin_student_add";
        }
        else if (studentService.checkStudent(student)=="studentID error") {
            model.addAttribute("error", "学号已被注册");
            return "admin_student_add";
        }
        else {
            model.addAttribute("error", "用户名与学号都已被注册");
            return "admin_student_add";
        }
    }


    //删除学生，post，book
    @RequestMapping(value = "/student_delete", method = RequestMethod.GET)
    public String admin_student_delete(@RequestParam("studentID") String studentID, Model model) {
        String res = studentService.deleteStudent(studentID);
        List<Student> list=studentService.selectAllStudent();
        model.addAttribute("list",list);
        return "student_admin_query";
    }

    //修改学生

    @RequestMapping(value = "admin_student_revise", method = RequestMethod.GET)
    public String admin_student_revise(
            @RequestParam("realname") String realname,
            @RequestParam("password") String password,
            @RequestParam("username") String username,
            @RequestParam("studentID") String studentID,
            Model model
    )
    {
        model.addAttribute("realname", realname);
        model.addAttribute("password", password);
        model.addAttribute("username", username);
        model.addAttribute("studentID", studentID);
        /*Student student = new Student(realname, studentID, username, password);
        System.out.println("revise in StudentController");
        studentService.reviseStudent(student);
        List<Student> list = studentService.selectAllStudent();
        model.addAttribute("list", list);*/
        return "admin_student_revise";
    }

    @RequestMapping(value = "admin_student_revise", method = RequestMethod.POST)
    public String admin_student_revise(
            @RequestParam("realname") String realname,
            @RequestParam("studentID") String studentID,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,HttpSession session
    )
    {
        Student student = new Student(realname, studentID, username, password);
        if (studentService.checkStudent(student)=="studentID error") {
            System.out.println("revise in StudentController");
            studentService.reviseStudent(student);
            List<Student> list = studentService.selectAllStudent();
            model.addAttribute("list", list);
            return "student_admin_query";
        }
        else if (studentService.checkStudent(student)=="error") {
            model.addAttribute("error", "用户名已被注册");
            model.addAttribute("realname", realname);
            model.addAttribute("password", password);
            model.addAttribute("username", username);
            model.addAttribute("studentID", studentID);
           /* List<Student> list = studentService.selectAllStudent();
            model.addAttribute("list", list);
            return "student_admin_query";*/
           return "admin_student_revise";
        }
        else {
            List<Student> list = studentService.selectAllStudent();
            model.addAttribute("list", list);
            return "student_admin_query";
        }
    }

}
