package SeleniumConcepts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v137.page.model.Screenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Iframe {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");
        //enter text inside single frame
        driver.switchTo().frame("singleframe");
        WebElement textbox =driver.findElement(By.xpath("//input[@type='text']"));
        textbox.sendKeys("hi");
        File src = textbox.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\Home\\Documents\\Screenshot\\pic1.png");
        src.renameTo(dest);

driver.switchTo().defaultContent();
driver.findElement(By.xpath("//a[contains(normalize-space(), 'Iframe with in an Iframe')]\n")).click();
//        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//FileHandler.copy(src,new File("C:\\Users\\Home\\Documents\\Screenshot\\pic.png"));

//       File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileHandler.copy(src,new File("C:\\Users\\Home\\Documents\\Screenshot\\pic1.png"));
        driver.quit();
    }
}
