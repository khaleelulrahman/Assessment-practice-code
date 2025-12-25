package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ShoppingTshirt {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("displaying shopping website");
        WebDriver driver=new ChromeDriver();
        driver.get("https://automationexercise.com/category_products/3");
        driver.manage().window().maximize();
        //verifying title
        String title= driver.getTitle();
        System.out.println("Title of the page is: "+title);
        Assert.assertEquals(title,"Automation Exercise - Tshirts Products");
//        //popup displaying from botom
//        driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
        //Register User
        //clicking on signup/login
        WebElement signUpbtn=driver.findElement(By.xpath("//a[contains(@href,'login')]"));
        signUpbtn.click();
        //verifying register/login page
        String registerPagetitle=driver.getTitle();
        String actualTitleRegister="Automation Exercise - Signup / Login";
        System.out.println(registerPagetitle);
        Assert.assertEquals(registerPagetitle,actualTitleRegister);
        //entering name and email for registration
        System.out.println("Entering name and email for registration");
        WebElement name=driver.findElement(By.name("name"));
        name.sendKeys("TestUser");
        WebElement email=driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]"));
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
        emailField.sendKeys("testtes5t33khaleel@gmail.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");


// Click Signup button
        signupBtn.click();

        js.executeScript("window.scrollBy(0, 300);");

        //gender button selection
        WebElement gender=driver.findElement(By.xpath("//input[@value='Mr']"));
        gender.click();

        Assert.assertTrue(gender.isEnabled());
        //Entering password
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("Test@1234");

        //Selection date of birth
        WebElement date=driver.findElement(By.xpath("//select[@id='days']"));
        WebElement month=driver.findElement(By.xpath("//select[@id='months']"));
        WebElement year=driver.findElement(By.xpath("//select[@name='years']"));

        Select selectdate=new Select(date);
       Select selectmonth=new Select(month);
        Select selectyear=new Select(year);
        selectdate.selectByVisibleText("15");
        selectmonth.selectByVisibleText("May");
        selectyear.selectByVisibleText("1993");
//sign up for newsletter checkbox
        WebElement newslettercheckbox=driver.findElement(By.id("newsletter"));
        newslettercheckbox.click();
        Assert.assertTrue(newslettercheckbox.isSelected());

        //firt name and last name
        WebElement firstName=driver.findElement(By.id("first_name"));
        firstName.sendKeys("Test");
        WebElement lastName=driver.findElement(By.id("last_name"));
        lastName.sendKeys("User");
        //address
        WebElement address=driver.findElement(By.id("address1"));
        address.sendKeys("123, Test Street, Test City");
        //State
        WebElement state=driver.findElement(By.id("state"));
        state.sendKeys("TestState");
        //city
        WebElement city=driver.findElement(By.id("city"));
        city.sendKeys("TestCity");
        //zipcode
        WebElement zipcode=driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("12345");
        //scroll down
        js.executeScript("window.scrollBy(0, 300);");
        //mobile number
        WebElement mobilenumber=driver.findElement(By.id("mobile_number"));
        mobilenumber.sendKeys("6439567890");
        //click on create account button
        WebElement createAccountbtn=driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccountbtn.click();
//        //verifying account created page
       WebElement successMsg = driver.findElement(
        By.xpath("//b[text()='Account Created!']"));

String actualText = successMsg.getText();

Assert.assertEquals(actualText, "ACCOUNT CREATED!");



        Thread.sleep(4000);
        driver.quit();


    }

}
