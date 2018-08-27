package com.example.service;


import com.example.dao.StudentDao;
import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;

    /**
     * 检查studentID、username存在
     * @param student
     */
    public String checkStudent(Student student) {
        System.out.println("Check in StudentService");
        int rs1 = studentDao.count(student.getUsername());
        int rs2 = studentDao.check(student.getStudentID());
        if (rs2 == 1 && rs1 != 1){
            System.out.println("studentID error");
            return "studentID error";
        }
        else if (rs1 == 1 && rs2 != 1){
            System.out.println("username error");
            return "username error";
        }
        else if (rs1 == 0 && rs2 == 0) {
            System.out.println("success");
            return "success";
        }
        return "error";
    }

    /**
     * 检查
     */

    /**
     * 查询单个学生信息
     * @param studentID
     * @return
     */
    public Student selectStudent(String studentID) {
        return studentDao.selectStudent(studentID);
    }

    /**
     * 查询所有学生信息
     * @return
     */
    public List<Student> selectAllStudent() {
        return studentDao.selectAllStudent();
    }

    /**
     * 根据人名查学生
     * @param realname
     * @return
     */
    public List<Student> selectByName(String realname) {
        realname = "%"+realname+"%";
        System.out.println(realname+"根据人名模糊查找，在StudentService");
        return studentDao.selectByName(realname);
    }

    /**
     * 根据用户名查学生
     * @param username
     * @return
     */
    public List<Student> selectByUsername(String username) {
        username = "%"+username+"%";
        System.out.println(username+"根据用户名模糊查找，在StudentService");
        return studentDao.selectByUsername(username);
    }

    /**
     * 根据学号查学生
     * @param studentID
     * @return
     */
    public List<Student> selectByStudentID(String studentID) {
        studentID = "%"+studentID+"%";
        System.out.println(studentID+"根据学号模糊查找，在StudentService");
        return studentDao.selectByStudentID(studentID);
    }

    /**
     * 添加学生信息
     * @param student
     */
    public String addStudent(Student student) {
        studentDao.addStudent(student);
        return "success";
        /*try {
            studentDao.addStudent(student);
            return "success";
        } catch (DuplicateKeyException e) {
            return "error";
        }*/
    }

    /**
     * 删除学生
     * @param studentID
     */
    public String deleteStudent(String studentID) {
        try {
            studentDao.deleteStudent(studentID);
            return "success";
        }catch (Exception e) {
            return "error";
        }
    }

    /**
     * 修改
     * @param student
     */
    public String reviseStudent(Student student) {
        studentDao.reviseStudent(student);
        return "success";
    }

}
