////import org.openqa.selenium.By;
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.WebElement;
////import org.openqa.selenium.chrome.ChromeDriver;
////
////public class AmazonProduct {
////    public static void main(String[] ars)
////    {
////        WebDriver driver= new ChromeDriver();
////        driver.get("https://www.amazon.com");
////        driver.manage().window().maximize();
////        WebElement continuetoShop=driver.findElement(By.xpath("//button[text()='Continue shopping']"));
////continuetoShop.click();
////WebElement SearchProductbox=driver.findElement(By.id("twotabsearchtextbox"));
////SearchProductbox.sendKeys("Kindle Paperwhite");
////driver.findElement(By.xpath("//*[@id=\"p_36/range-slider_slider-item_lower-bound-slider"]")).click();
////driver.close();
////
////    }
////}
//
////with try catch block
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class AmazonProduct {
//    public static void main(String[] ars) throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.amazon.com");
//        driver.manage().window().maximize();
//
//        try {
//            // If Continue shopping is displayed, click it
//            WebElement continueToShop = driver.findElement(
//                    By.xpath("//button[text()='Continue shopping']"));
//            continueToShop.click();
//        } catch (NoSuchElementException e) {
//            // If Continue shopping is not displayed, do nothing and proceed
//        }
//        // dismiss button handling
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement dismissButton = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//span[contains(@class,'glow-toaster-button-dismiss')]//input[@type='submit' or @class='a-button-input']")));
//        if (dismissButton.isDisplayed()) {
//            dismissButton.click();
//        }
//
//        // In both cases, now search for product
//        WebElement searchProductBox = driver.findElement(By.id("twotabsearchtextbox"));
//        searchProductBox.sendKeys("Kindle Paperwhite");
//        Thread.sleep(4000);
//
//        driver.findElement(
//                        By.xpath("//*[@id='p_36/range-slider_slider-item_lower-bound-slider']"))
//                .click();
//        driver.findElement(By.xpath("div[aria-label='kindle paperwhite']\n")).click();
//
//        driver.close();
//    }
//}
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class AmazonProduct {
//    public static void main(String[] ars) throws InterruptedException {
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.amazon.com");
//        driver.manage().window().maximize();
//
//        // HANDLE "Continue Shopping" IF PRESENT
//        try {
//            WebElement continueToShop = driver.findElement(
//                    By.xpath("//button[text()='Continue shopping']"));
//            continueToShop.click();
//        } catch (NoSuchElementException e) {
//            // ignore if not present
//        }
//
//        // HANDLE DISMISS BUTTON ONLY IF PRESENT (NO ERROR)
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//        try {
//            WebElement dismissButton = wait.until(
//                    ExpectedConditions.elementToBeClickable(
//                            By.xpath("//span[contains(@class,'glow-toaster-button-dismiss')]//input")
//                    )
//            );
//            dismissButton.click();
//        } catch (Exception e) {
//            // Dismiss button not available → continue normally
//        }
//
//        // NOW SEARCH PRODUCT
//        WebElement searchProductBox = driver.findElement(By.id("twotabsearchtextbox"));
//        searchProductBox.sendKeys("Kindle Paperwhite");
//
//        Thread.sleep(3000);
//
//        // CLICK PRICE RANGE SLIDER IF NEEDED
//        try {
//            driver.findElement(
//                            By.xpath("//*[@id=\"p_36/range-slider\"]/form/div[2]"))
//                    .click();
//        } catch (Exception e) {
//            // ignore if not found
//        }
//
//        // Example product click (fix your XPath)
//        try {
//            driver.findElement(
//                    By.xpath("//div[@aria-label='kindle paperwhite']")
//            ).click();
//        } catch (Exception e) {
//            // ignore if not found
//        }
//        Thread.sleep(3000);
//
//        WebElement slider = driver.findElement(By.xpath("//*[@id=\"p_36/range-slider\"]/form/div[2]\n"));
//
//// Create Actions instance
//        Actions actions = new Actions(driver);
//
//// Move slider 50 pixels to the right
//        actions.dragAndDropBy(slider, 50, 0).perform();
//
//// Move slider 30 pixels to the left
//        actions.dragAndDropBy(slider, -30, 0).perform();
//
//        Thread.sleep(2000);
//        driver.close();
//    }
//}





           /***************with logs*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonProduct {
    public static void main(String[] ars) throws InterruptedException {

        System.out.println("Launching Chrome Browser...");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        System.out.println("Amazon homepage opened.");

        // HANDLE "Continue Shopping"
        System.out.println("Checking for 'Continue shopping' button...");
        try {
            WebElement continueToShop = driver.findElement(
                    By.xpath("//button[text()='Continue shopping']"));
            continueToShop.click();
            System.out.println("'Continue shopping' clicked.");
        } catch (NoSuchElementException e) {
            System.out.println("'Continue shopping' not found.");
        }

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

        // SEARCH PRODUCT
        System.out.println("Typing 'Kindle Paperwhite' in search box...");
        WebElement searchProductBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchProductBox.sendKeys("Kindle Paperwhite");
        System.out.println("Search text entered.");
        Thread.sleep(3000);

        // CLICK PRICE RANGE SLIDER SECTION
        System.out.println("Checking for Price Range Slider section...");
        try {
            driver.findElement(
                            By.xpath("//*[@id=\"p_36/range-slider\"]/form/div[2]"))
                    .click();
            System.out.println("Price slider area clicked.");
        } catch (Exception e) {
            System.out.println("Price slider section not found.");
        }

        // CLICK A PRODUCT (if exists)
        System.out.println("Trying to click Kindle product...");
        try {
            driver.findElement(
                    By.xpath("//div[@aria-label='kindle paperwhite.']")
            ).click();
            System.out.println("Kindle Paperwhite item clicked..");
        } catch (Exception e) {
            System.out.println("Kindle Paperwhite item not found.");
        }

        Thread.sleep(3000);

        // SLIDER DRAG ELEMENT (fixed Xpath)
        System.out.println("Locating price slider handle...");
        WebElement slider = driver.findElement(
                By.xpath("//*[@id='p_36/range-slider']//span[contains(@class,'a-slider-handle')][1]")
        );
        System.out.println("Slider located successfully.");

        // ACTIONS FOR DRAG & DROP
        Actions actions = new Actions(driver);

        System.out.println("Dragging slider 50px to the right...");
        actions.dragAndDropBy(slider, 50, 0).perform();

        System.out.println("Dragging slider 30px to the left...");
        actions.dragAndDropBy(slider, -30, 0).perform();

        System.out.println("Slider movement complete.");
        Thread.sleep(2000);

        // CLOSE BROWSER
        System.out.println("Closing browser...");
        driver.close();
        System.out.println("Test completed successfully.");
    }
}




