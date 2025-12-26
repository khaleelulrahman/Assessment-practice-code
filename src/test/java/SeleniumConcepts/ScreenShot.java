package SeleniumConcepts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    public static void main(String[] args) throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/?zx=1766253045677&no_sw_cr=1");
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("C:\\Users\\Home\\Documents\\Screenshot\\google.png"));
      WebElement searchBox=  driver.findElement(By.id("APjFqb"));
      searchBox.click();
        File sourcefILE = searchBox.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\Home\\Documents\\Screenshot\\googleelement.png");
        sourcefILE.renameTo(dest);

        driver.quit();

    }
}
