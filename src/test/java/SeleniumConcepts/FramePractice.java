package SeleniumConcepts;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class FramePractice {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");



        driver.switchTo().frame("frm1");
        WebElement element =         driver.findElement(By.id("course"));





        element.click();
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File(    "C:\\Users\\Home\\IdeaProjects\\PracticeCode\\Screenshots\\frameiceScreenshot.png"));

        //switching back to pare
        Thread.sleep(5000);
        driver.quit();
    }

}
