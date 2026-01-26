package SeleniumConcepts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class KeyboardActions {
    public static void main(String[] args) throws IOException {

        // Initiate WebDriver
        WebDriver driver = new ChromeDriver();

        // Implicit wait (Selenium 4)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(17));

        // Open webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");

        // Locate input box
        WebElement e = driver.findElement(By.id("fullname"));

        // Actions class
        Actions act = new Actions(driver);

        // Perform SHIFT + text
        act.moveToElement(e)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("selenium")
                .keyUp(Keys.SHIFT)
                .perform();

        // Print entered text
        System.out.println("Text entered: " + e.getAttribute("value"));
        //File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File src= e.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\Home\\IdeaProjects\\PracticeCode\\Screenshots\\practiceScreenshot.png"));
//        C:\Users\Home\IdeaProjects\PracticeCode\Screenshots\practiceScreenshot.png
        // Close browser
        driver.quit();
    }
}
