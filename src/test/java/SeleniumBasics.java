import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumBasics {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        JavascriptExecutor js=(JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/documentation/webdriver/getting_started/first_script/");
        String actualTitle=driver.getTitle();
        String expectedTitle="Write our first Selenium script | Selenium";
        //Assert.assertEquals(actualTitle,expectedTitle);
       WebElement Element= driver.findElement(By.linkText("About Selenium"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
//        if(expectedTitle.equals(actualTitle))
//        {
//            JavascriptExecutor js=(JavascriptExecutor) driver;
//            js.executeScript("window.scrollBy(0,480)","");
//
//        }
//        else
//        {
//            JavascriptExecutor js=(JavascriptExecutor) driver;
//            js.executeScript("window.scrollBy(0,2000)","");
//
//        }
Thread.sleep(3000);
        driver.quit();

}
        }

