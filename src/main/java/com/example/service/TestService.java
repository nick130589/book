package com.example.service;

import com.example.dao.TestDao;
import com.example.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("testService")
public class TestService {
    @Autowired
    TestDao testDao;

    /**
     * 查询所有test信息
     */
    public List<Test> selectAllTest(){
        return testDao.selectAllTest();
    }

    /**
     *根据testName查
     * @param testName
     */
    public List<Test> selectBytestName(String testName){
        testName="%"+testName+"%";
        System.out.println(testName+"根据作者模糊查，在BookService");
        return testDao.selectBytestName(testName);
    }

    /**
     * 添加图书信息
     * @param test
     */
    public String  addTest(Test test){
        testDao.addTest(test);
        return "success";
    }

    /**
     * 删除图书
     * @param testId
     */
    public String deleteTest(String testId){
        try{
            testDao.deleteTest(testId);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }
}
