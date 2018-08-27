package com.example.dao;

import com.example.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    /**
     * @param username
     */
    public int count(String username);

    /**
     * @param studentID
     */
    public int check(String studentID);

    /**
     * 查询单个学生信息
     * @param studentID
     * @return
     */
    public Student selectStudent(String studentID);

    /**
     * 查询所有学生信息
     * @return
     */
    public List<Student> selectAllStudent();

    /**
     * 根据人名查学生
     * @param realname
     * @return
     */
    public List<Student> selectByName(String realname);

    /**
     * 根据用户名查学生
     * @param username
     * @return
     */
    public List<Student> selectByUsername(String username);

    /**
     * 根据学号查学生
     * @param studentID
     * @return
     */
    public List<Student> selectByStudentID(String studentID);

    /**
     * 添加学生信息
     * @param student
     */
    public void addStudent(Student student);

    /**
     * 删除学生
     * @param studentID
     */
    public void deleteStudent(String studentID);

    /**
     * 修改学生
     * @param student
     */
    public void reviseStudent(Student student);

}
