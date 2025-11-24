import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testng {

    @Test
    public void testB()
    {
WebDriver driver=new ChromeDriver();
    driver.get("https://www.vskills.in/interview-questions/playwright-interview-questions");
    }
    @Test
    public void testA()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/?zx=1756489330526&no_sw_cr=1 ");
    }
           }



