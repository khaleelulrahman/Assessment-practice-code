package FailedScenarionScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Base {
    public static WebDriver driver;

    public  static void initialization()
    {
        driver= new ChromeDriver();
        driver.get("https://www.google.com/");
    }
    public void failed() throws IOException {
        File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("C:\\Users\\Home\\IdeaProjects\\PracticeCode\\Screenshots\\screenshot.png"));
    }
}
