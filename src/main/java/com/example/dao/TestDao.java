package com.example.dao;

import com.example.entity.Test;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TestDao {
    /**
     * 查询所有的test信息
     * */
    public List<Test> selectAllTest();

    /**
     * 根据testId查找
     * @param testId
     * @return
     */
    public List<Test> selectBytestId(String testId);

    /**
     * 根据testName查找
     * @param testName
     * @return
     */
    public List<Test> selectBytestName(String testName);

    /**
     * 根据testDate查找
     * @param testDate
     * @return
     */
    public List<Test> selectBytestDate(String testDate);

    /**
     * 根据testContent查找
     * @param testContent
     * @return
     */
    public List<Test> selectBytestContent(String testContent);

    /**
     * 添加test信息
     * @param test
     */
    public void addTest(Test test);

    /**
     * 删除test信息
     * @param testId
     */
    public void deleteTest(String testId);
}
