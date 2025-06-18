//package utils;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//public class ExtentReportManager {
//    private static ExtentReports extent;
//
//    public static ExtentReports getInstance() {
//        if (extent == null) {
//            ExtentSparkReporter spark = new ExtentSparkReporter("./reports/IRCTCReport.html");
//            spark.config().setDocumentTitle("IRCTC Automation Report");
//            spark.config().setReportName("IRCTC Booking Test Results");
//
//            extent = new ExtentReports();
//            extent.attachReporter(spark);
//        }
//        return extent;
//    }
//}
package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("./reports/IRCTCReport.html");
            spark.config().setDocumentTitle("IRCTC Automation Report");
            spark.config().setReportName("IRCTC Booking Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    public static void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }
}
