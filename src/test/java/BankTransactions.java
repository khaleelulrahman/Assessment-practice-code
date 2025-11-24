import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BankTransactions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
        String actualTitle=driver.getTitle();
        String expectedTitle="Protractor practice website - Banking App";
        Assert.assertEquals(actualTitle,expectedTitle,"page title doesnt  match");
        Thread.sleep(2000);

        driver.manage().window().maximize();
        Thread.sleep(2000);


        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/button")).click();
        Thread.sleep(2000);

//        WebElement usernameDropdown= driver.findElement(By.id("userSelect"));
//        Select select=new Select(usernameDropdown);
//        select.selectByVisibleText("Hermoine Granger");
//        Thread.sleep(2000);
        WebElement dropdown = driver.findElement(By.id("userSelect"));
        Select select = new Select(dropdown);

// Select a value
        select.selectByVisibleText("Hermoine Granger");

// Get the selected value
        String selectedValue = select.getFirstSelectedOption().getText();

// Print it
        System.out.println("Selected Dropdown Value: " + selectedValue);



        WebElement login=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/button"));
        login.click();
        Thread.sleep(2000);
        //welcome username page
        String profilePagename= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/strong/span")).getText();
        System.out.println("user name is displayed as "+ profilePagename);

if(profilePagename.equals(selectedValue))
{
//click on deposittab
    WebElement depositBtn = driver.findElement(By.xpath("//button[contains(text(),'Deposit')]"));
    depositBtn.click();
    //get the current balance
    String currentbalance=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/strong[2]")).getText();
    System.out.println("currentbalance is "+ currentbalance);
    //enter deposit amt
    Thread.sleep(2000);
    WebElement amttexbox = driver.findElement(By.cssSelector("input[placeholder='amount']"));

    amttexbox.sendKeys("1000");
    Thread.sleep(2000);
    //click on deposit buton after entering amt
    WebElement depositbt2 = driver.findElement(By.xpath("(//button[contains(text(),'Deposit')])[2]"));
    depositbt2.click();
    Thread.sleep(3000);
    //checking balace added 1000+ amount
    int expectedAfterDeposit = Integer.parseInt(currentbalance + 1000);
    System.out.println(expectedAfterDeposit);


    WebElement withdrawlBtn = driver.findElement(By.xpath("//button[contains(text(),'Withdrawl')]"));
    withdrawlBtn.click();
    Thread.sleep(2000);
    WebElement witdrwalamttexbox = driver.findElement(By.cssSelector("input[placeholder='amount']"));


    witdrwalamttexbox.sendKeys("500");

    WebElement withdrawbtntwo = driver.findElement(By.xpath("(//button[contains(text(),'Withdraw')])[2]"));
    withdrawbtntwo.click();
    Thread.sleep(2000);
}
else {
    System.out.println("login name mismatched");
}


driver.quit();

    }
}
