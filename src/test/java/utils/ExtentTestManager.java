package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.concurrent.ConcurrentHashMap;

public class ExtentTestManager {
    private static final ConcurrentHashMap<Long, ExtentTest> extentTestMap = new ConcurrentHashMap<>();
    private static final ExtentReports extent = ExtentManager.createExtentReports();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().getId());  //Use correct thread ID type
    }

    public static synchronized ExtentTest startTest(String testName, String desc, String category) {
        ExtentTest test = extent.createTest(testName, desc).assignCategory(category);
        extentTestMap.put(Thread.currentThread().getId(), test);  //Store with correct thread ID
        return test;
    }
}

