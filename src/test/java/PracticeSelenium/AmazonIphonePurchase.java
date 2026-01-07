package PracticeSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AmazonIphonePurchase {

    WebDriver driver;
    WebDriverWait wait;
    WebElement priceInCart;
    String priceInCartText;
    //storing price of iphone
    WebElement priceInProductDetail;
    String priceInproductDetailText;
    WebElement proceedToBuyBtn;


    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Explicit wait only (NO implicit wait)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.amazon.in/");
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[text()='Dismiss']")
            )).click();
            System.out.println("Dismiss popup clicked");
        } catch (Exception e) {
            System.out.println("Dismiss popup not present");
        }
    }

    @Test(priority = 3)
    public void searchIphone13() throws InterruptedException {
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("twotabsearchtextbox")
                )
        );
        searchBox.sendKeys("iPhone 15");
        searchBox.submit();
        System.out.println("Searched for iPhone 15");
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        WebElement iphone= driver.findElement(By.xpath("//span[contains(text(),'iPhone 15 (128 GB) - Blue')]"));
        String iphoneText= iphone.getText();
        iphone.click();
        System.out.println("iPhone 15 selected");
        Thread.sleep(3000);

        String parentWindow = driver.getWindowHandle();


        // Switch to new tab
        for(String childwindow:driver.getWindowHandles())
        {
            if(!childwindow.equals(parentWindow))
            {
                driver.switchTo().window(childwindow);
            }
        }

        // switched to product details page
        if (driver.findElements(By.xpath("//span[contains(text(),'iPhone 15')]")).size() > 0) {
            System.out.println("iPhone 15 is present on the shopping cart page");
        } else {
            System.out.println("iPhone 15 is NOT present on the page");
        }
        priceInProductDetail  = driver.findElement(By.className("a-price-whole"));
        priceInproductDetailText= priceInProductDetail.getText();



        System.out.println("Price of iPhone 15 in product detail page: ₹" + priceInproductDetailText);

//
    }
    // geting price of iphone
//click on add to cart
    @Test(priority = 4)
    public void addToCart() {
        WebElement addtoCartBtn = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addtoCartBtn);
        addtoCartBtn.click();

        System.out.println("Add to Cart button clicked");
    }
    //verify added to cart
    @Test(priority = 5)
    public void verifyAddedToCart() {
        WebElement proceedtoBuybtn = driver.findElement(By.name("proceedToRetailCheckout"));
        proceedtoBuybtn.isDisplayed();
        System.out.println("iPhone successfully added to cart, Proceed to Buy button is displayed");
        try {
            WebElement iphone15 =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//span[contains(text(),'iPhone 15')]")
                    ));
            System.out.println("iPhone 15 is present in add to cart page");
        } catch (Exception e) {
            System.out.println("iPhone 15 is NOT present");
        }


priceInCart=driver.findElement(By.xpath("(//span[@class='a-offscreen'])[2]"));
        priceInCartText = priceInCart.getText();
        System.out.println("Price in inCart page ₹" + priceInCartText);
SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(priceInproductDetailText,priceInCartText,"Price mismatch between product detail and cart");
        softAssert.assertAll();
    }
    @Test(priority = 6)
    public void gotoCart()
    {
        WebElement cartBtn= driver.findElement(By.xpath("//div[@id='nav-cart-count-container']"));
        cartBtn.click();
        System.out.println("Navigated to cart page");
    }
//    public void proceedToBuy()
//    {
//        proceedToBuyBtn=driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']"));
//        proceedToBuyBtn.click();
//        System.out.println("Proceeded to buy clicked, navigated to sign-in page");
//
//    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Browser closed");
    }
}
