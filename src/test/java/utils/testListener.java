package utils;

import TestBase.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class testListener extends BaseTest implements ITestListener {


    @Override
        public void onTestStart(ITestResult result) {
            ITestListener.super.onTestStart(result);
            System.out.println("The test has started successfully");
        }
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test == null) {
            System.err.println("ExtentTest is NULL for test: " + result.getMethod().getMethodName());
            return;}

        test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
        System.out.println("Test Passed: " + result.getMethod().getMethodName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test == null) {//Prevents NullPointerException
            System.err.println("ExtentTest is NULL for test: " + result.getMethod().getMethodName());
            return;// Exit the method to avoid calling log() on null
        }
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = ExtentTestManager.getTest();

        if (test == null) {
            System.err.println("ExtentTest is NULL for test: " + result.getMethod().getMethodName());
            return;
        }
        test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
        System.out.println("Test Skipped: " + result.getMethod().getMethodName());
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Flushing ExtentReports...");

        ExtentReports extent = ExtentManager.createExtentReports();
        if (extent != null) {
            extent.flush();
            System.out.println("ExtentReports successfully written to file.");
        } else {
            System.err.println("ExtentReports is NULL! Cannot flush.");
        }

}
}
