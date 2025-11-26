




           /***************with logs*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
        searchProductBox.sendKeys("kindle paperwhite");
        System.out.println("Search text entered.");
        Thread.sleep(3000);
//
//        // CLICK PRICE RANGE SLIDER SECTION
//        System.out.println("Checking for Price Range Slider section...");
//        try {
//            driver.findElement(
//                            By.xpath("//*[@id=\"p_36/range-slider\"]/form/div[2]"))
//                    .click();
//            System.out.println("Price slider area clicked.");
//        } catch (Exception e) {
//            System.out.println("Price slider section not found.");
//        }

        // CLICK A PRODUCT (if exists)
        System.out.println("Trying to click Kindle product...");
        try {
            driver.findElement(
                    By.xpath("//div[@aria-label='kindle paperwhite']")
            ).click();
            System.out.println("Kindle Paperwhite item clicked..");
        } catch (Exception e) {
            System.out.println("Kindle Paperwhite item not found.");
        }
//        driver.findElement(By.xpath("//*[@id=\"p_36/dynamic-picker-0\"]/span/a/span")).click();
//        System.out.println("upto 150 clicked");

        Thread.sleep(3000);

//        // SLIDER DRAG ELEMENT (fixed Xpath)
//        System.out.println("Locating price slider handle...");
//        WebElement slider = driver.findElement(
//                By.xpath("//*[@id=\"p_36/range-slider_slider-item_lower-bound-slider\"]")
//        );
//        slider.click();
//        Thread.sleep(3000);
//        System.out.println("location of 100 dollar range"+slider.getLocation());
//        System.out.println("Slider located successfully.");

//        // ACTIONS FOR DRAG & DROP
//        Actions actions = new Actions(driver);
//
//        System.out.println("Dragging slider 50px to the right...");
//        actions.dragAndDropBy(slider, 16, 76).perform();
//        Thread.sleep(2000);
//
////        System.out.println("Dragging slider 30px to the left...");
////        actions.dragAndDropBy(slider, -30, 0).perform();
//
//        System.out.println("Slider movement complete.");
//        Thread.sleep(2000);

        //click on 4star and up
        driver.findElement(By.xpath("//*[@id=\"p_72/2661618011\"]/span/div/a/i")).click();
        System.out.println("4 star and up filter applied");
        Thread.sleep(2000);

        //selecting second product from the result
        driver.findElement(By.xpath("//span[contains(text(),'3 Pack Anti-Glare Matte Screen Protector for 7\" Ki')]")).click();
        System.out.println("second product clicked");
        Thread.sleep(2000);

        //get the name,price of the product
        String productName = driver.findElement(By.xpath("//span[contains(text(),'3 Pack Anti-Glare Matte Screen Protector for 7\" Ki')]")).getText();
        System.out.println(productName);

        //clicking on see all buying options
        WebElement seeAllBuyingOptions = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@title='See All Buying Options']"))
        );
        seeAllBuyingOptions.click();
//
Thread.sleep(3000);

//compare product name before adding to cart
        String prodNameBeforeCheckoutpage=driver.findElement(By.xpath("//div[@class='a-fixed-left-grid-inner']//h5[@id='aod-asin-title-text']")).getText();
        System.out.println(prodNameBeforeCheckoutpage);
        Assert.assertEquals(productName,prodNameBeforeCheckoutpage,"Product names do not match before checkout page.");
        //clicking on add to cart
      driver.findElement(By.xpath("//input[@name='submit.addToCart']")).click();
        System.out.println("Product added to cart.");
        WebElement proceedtoCheckout = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("input[value='Proceed to checkout']"))
        );
        proceedtoCheckout.click();

        // CLOSE BROWSER
        System.out.println("Closing browser...");
        driver.close();
        System.out.println("Test completed successfully.");

    }
}




