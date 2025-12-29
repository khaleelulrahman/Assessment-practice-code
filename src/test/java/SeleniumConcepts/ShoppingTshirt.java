package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShoppingTshirt {
    WebDriver driver;
    JavascriptExecutor js;
    @BeforeMethod
        public  void setUp() {




        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    System.out.println("displaying shopping website");

    driver.get("https://automationexercise.com/category_products/3");
    driver.manage().window().maximize();
    //verifying title
    String title = driver.getTitle();
    System.out.println("Title of the page is: " + title);
    Assert.assertEquals(title, "Automation Exercise - Tshirts Products");

}
@Test
        public  void registerUser() throws InterruptedException {

//        //******** Register User ********//
        //clicking on signup/login
Thread.sleep(3000);

    WebElement signUpbtn = driver.findElement(By.xpath("//a[contains(@href,'login')]"));
        signUpbtn.click();
    Thread.sleep(3000);

    //verifying register/login page
        String registerPagetitle = driver.getTitle();
        String actualTitleRegister = "Automation Exercise - Signup / Login";
        System.out.println(registerPagetitle);
        Assert.assertEquals(registerPagetitle, actualTitleRegister);
        //entering name and email for registration
        System.out.println("Entering name and email for registration");

    WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("TestUser");
        WebElement email = driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]"));
        //email.sendKeys("testkhaleel12@gmail.com");
        WebElement emailField = driver.findElement(
                By.xpath("(//input[@placeholder='Email Address'])[2]"));

// Enter invalid email
        emailField.sendKeys("tedst");

// Click Signup button
        WebElement signupBtn = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupBtn.click();

// Get validation message
        String validationMessage = emailField.getAttribute("validationMessage");

        System.out.println("Validation message is: " + validationMessage);

// Assertion
        Assert.assertTrue(validationMessage.contains("@"),
                "Validation message not displayed for invalid email");

//        log.info("Invalid email popup verified successfully");
        // Enter valid email
    emailField.clear();

    emailField.sendKeys("tesolo0haleel@gmail.com");
        js.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(5000);


// Click Signup button
        signupBtn.click();

        js.executeScript("window.scrollBy(0, 300);");

        //gender button selection
        WebElement gender = driver.findElement(By.xpath("//input[@value='Mr']"));
        gender.click();

        Assert.assertTrue(gender.isEnabled());
        //Entering password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Test@1234");

        //Selection date of birth
        WebElement date = driver.findElement(By.xpath("//select[@id='days']"));
        WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
        WebElement year = driver.findElement(By.xpath("//select[@name='years']"));

        Select selectdate = new Select(date);
        Select selectmonth = new Select(month);
        Select selectyear = new Select(year);
        selectdate.selectByVisibleText("15");
        selectmonth.selectByVisibleText("May");
        selectyear.selectByVisibleText("1993");
//sign up for newsletter checkbox
        WebElement newslettercheckbox = driver.findElement(By.id("newsletter"));
        newslettercheckbox.click();
        Assert.assertTrue(newslettercheckbox.isSelected());

        //firt name and last name
        WebElement firstName = driver.findElement(By.id("first_name"));
        firstName.sendKeys("Test");
        WebElement lastName = driver.findElement(By.id("last_name"));
        lastName.sendKeys("User");
        //address
        WebElement address = driver.findElement(By.id("address1"));
        address.sendKeys("123, Test Street, Test City");
        //State
        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("TestState");
        //city
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("TestCity");
        //zipcode
        WebElement zipcode = driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("12345");
        //scroll down
        js.executeScript("window.scrollBy(0, 300);");
        //mobile number
        WebElement mobilenumber = driver.findElement(By.id("mobile_number"));
        mobilenumber.sendKeys("64090867890");
        //click on create account button
        WebElement createAccountbtn = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccountbtn.click();
//        //verifying account created page
        WebElement successMsg = driver.findElement(
                By.xpath("//b[text()='Account Created!']"));

        String actualText = successMsg.getText();

        Assert.assertEquals(actualText, "ACCOUNT CREATED!");
    }
@Test(enabled = false)
        public  void login() throws InterruptedException {



//// login button

        WebElement logisignUpbtn=driver.findElement(By.xpath("//a[contains(@href,'login')]"));
       logisignUpbtn.click();
       WebElement loginEmail=driver.findElement(By.xpath("//input[@type='email' and @data-qa='login-email']"));
       loginEmail.sendKeys("testrahman@gmail.com");
         WebElement loginPassword=driver.findElement(By.xpath("//input[@type='password' and @data-qa='login-password']"));
    loginPassword.sendKeys("test123");
    WebElement loginBtn=driver.findElement(By.xpath("//button[@data-qa='login-button']"));
    loginBtn.click();
    //choosing men's tshirt in category
        js.executeScript("window.scrollBy(0, 600);");

        WebElement mensTshirtCategory=driver.findElement(By.xpath("//a[@href='#Men']"));
    mensTshirtCategory.click();
        js.executeScript("window.scrollBy(0, 100);");
    WebElement  tshirtProduct=driver.findElement(By.xpath("//a[text()='Tshirts ']"));
    tshirtProduct.click();
//verify page title
String tshirtpageTitle=driver.getTitle();
Assert.assertEquals(tshirtpageTitle,"Automation Exercise - Tshirts Products");
////click on view product then adding to cart
//        WebElement  viewProductBtn=driver.findElement(By.xpath("//a[@href='/product_details/2']"));
//        viewProductBtn.click();
        // Locate View Product button
        WebElement viewProductBtn =
                driver.findElement(By.xpath("//a[@href='/product_details/2']"));

// Scroll to the element
        js.executeScript("arguments[0].scrollIntoView(true);", viewProductBtn);

// Click the element
        viewProductBtn.click();

        WebElement addtoCartBtn=driver.findElement(By.xpath("//button[@type='button']"));
        addtoCartBtn.click();
//        String addedtoCartMsg=driver.findElement(By.xpath("//p[text()='Your product has been added to cart.']")).getText();
//        //Assert.assertEquals(addedtoCartMsg,"Your product has been added to cart.");
//        System.out.println(addedtoCartMsg);
        By continueShoppingBtn =
                By.xpath("//button[normalize-space()='Continue Shopping']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement continueBtn =
                wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingBtn));

        continueBtn.click();

        Thread.sleep(2000);

}
    @AfterMethod
        public  void tearDown()
        {


                driver.quit();
            }
        }

