package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataProvider {

    WebDriver driver;

    @org.testng.annotations.DataProvider(name = "loginData")
    public String[][] loginData() {

        String[][] data = new String[1][2];   // 1 test, 2 parameters
        data[0][0] = "testrahman@gmail.com";  // email
        data[0][1] = "test123";               // password
        return data;
    }

    @Test(dataProvider = "loginData")
    public void login(String email, String password) {

        driver = new ChromeDriver();   //
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/category_products/3");

        WebElement logisignUpbtn = driver.findElement(By.xpath("//a[contains(@href,'login')]"));
        logisignUpbtn.click();

        WebElement loginEmail = driver.findElement(By.xpath("//input[@type='email' and @data-qa='login-email']"));
        loginEmail.sendKeys(email);

        WebElement loginPassword = driver.findElement(By.xpath("//input[@type='password' and @data-qa='login-password']"));
        loginPassword.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginBtn.click();

        driver.quit();
    }
}
