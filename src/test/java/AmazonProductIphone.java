import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonProductIphone {
    public static void main(String[] args)
    {
        System.out.println("This is a placeholder for AmazonProductIphone test code.");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //click on continue shopping if present
        driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/div/div/form/div/div/span/span/button")).click();
        // HANDLE DISMISS BUTTON
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        System.out.println("Checking for toaster dismiss button...");

        try {
            WebElement dismissButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//span[contains(@class,'glow-toaster-button-dismiss')]//input")
                    )
            );
            dismissButton.click();
            System.out.println("Dismiss button clicked.");
        } catch (Exception e) {
            System.out.println("Dismiss button not present.");
        }

        //search iPhone 13
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone 13");
    driver.quit();
    }
}
