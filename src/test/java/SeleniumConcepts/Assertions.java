package SeleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Assertions {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/?zx=1766253045677&no_sw_cr=1");
        String title= driver.getTitle();
//        Assert.assertEquals(title,"Google");
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(title,"Google1","Title is not matching");
        driver.quit();
      soft.assertAll();

    }

}
