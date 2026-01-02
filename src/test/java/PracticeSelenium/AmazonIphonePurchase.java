package PracticeSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class AmazonIphonePurchase {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Explicit wait only (NO implicit wait)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.amazon.com/");
        System.out.println("Amazon homepage opened");
    }

    @Test(priority = 1)
    public void handleContinueShopping() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Continue shopping')]")
            )).click();
            System.out.println("Continue shopping clicked");
        } catch (Exception e) {
            System.out.println("Continue shopping button not present");
        }
    }

    @Test(priority = 2)
    public void dismissPopup() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='Dismiss']")
            )).click();
            System.out.println("Dismiss popup clicked");
        } catch (Exception e) {
            System.out.println("Dismiss popup not present");
        }
    }

    @Test(priority = 3)
    public void searchIphone13() {
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("twotabsearchtextbox")
                )
        );
        searchBox.sendKeys("iPhone 13");
        searchBox.submit();
        System.out.println("Searched for iPhone 13");
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        WebElement iphone= driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 13, 128GB, Midnight, for TracFone (Re')]"));
        iphone.click();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Browser closed");
    }
}
