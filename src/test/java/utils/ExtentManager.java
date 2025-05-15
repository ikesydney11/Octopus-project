package utils;
import TestBase.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterSuite;


public class ExtentManager extends BaseTest {
        public static ExtentReports extent = new ExtentReports();
        public synchronized static ExtentReports createExtentReports() {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Desktop/test_report.html");
            extent.attachReporter(sparkReporter);
            sparkReporter.config().setReportName("My Framework");
            sparkReporter.config().setTheme(Theme.STANDARD);
            extent.setSystemInfo("Author", "Ikechukwu");
            extent.setSystemInfo("environment", "Test");
            return extent;

}


}

