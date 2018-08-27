package com.example.entity;

public class Test {
    private int testId;
    private String testName;
    private String testDate;
    private String testContent;

    public Test(int testId,String testName,String testDate,String testContent){
        this.testId = testId;
        this.testName = testName;
        this.testDate = testDate;
        this.testContent = testContent;
    }

    public Test(){

    }
    public int getTestId() {
        return testId;
    }

    public String getTestName() {
        return testName;
    }
    public String getTestDate() {
        return testDate;
    }
    public String getTestContent() {
        return testContent;
    }
}
