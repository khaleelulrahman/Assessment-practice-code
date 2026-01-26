package SeleniumConcepts.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {


    public class ExtentReportManager {

        public static ExtentReports extent;

        public static ExtentReports getReportInstance() {

            if (extent == null) {

                ExtentSparkReporter reporter =
                        new ExtentSparkReporter("reports/ExtentReport.html");

                reporter.config().setReportName("Automation Test Report");
                reporter.config().setDocumentTitle("Selenium Execution Report");

                extent = new ExtentReports();
                extent.attachReporter(reporter);

                extent.setSystemInfo("Tester", "Khaleel");
                extent.setSystemInfo("Environment", "QA");
                extent.setSystemInfo("Browser", "Chrome");
                extent.setSystemInfo("Executed on","Monday");
            }
            return extent;
        }
    }

}
