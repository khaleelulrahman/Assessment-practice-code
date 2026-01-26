package SeleniumConcepts.ExtentReport;


    import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

    public class LoginTest {

        WebDriver driver;
        ExtentReports extent;
        ExtentTest test;

        @BeforeTest
        public void setupReport() {
            extent = ExtentReportManager.getReportInstance();
        }

        @BeforeMethod
        public void setup() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        public void googleTitleTest() {
            test = extent.createTest("Google Title Test");

            driver.get("https://www.google.com");
            test.info("Navigated to Google");

            String title = driver.getTitle();
            test.info("Page title captured");

            Assert.assertEquals(title, "Google");
            test.pass("Title matched successfully");
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }

        @AfterTest
        public void flushReport() {
            extent.flush();
        }
    }


