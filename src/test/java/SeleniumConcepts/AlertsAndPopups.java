package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertsAndPopups {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://vinothqaacademy.com/alert-and-popup/");
        driver.manage().window().maximize();
//        driver.findElement(By.xpath("//button[@name='alertbox']")).click();
//        driver.switchTo().alert().accept();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[@name='confirmalertbox']")).click();
//        driver.switchTo().alert().accept();
        Thread.sleep(2000);
//
//
//        driver.findElement(By.xpath("//button[@name='confirmalertbox']")).click();
//        driver.switchTo().alert().dismiss();
//        Thread.sleep(3000);

driver.findElement(By.xpath("//button[@name='promptalertbox1234']")).click();
//String popuptext=driver.switchTo().alert().getText();
driver.switchTo().alert().sendKeys("Welcome to Selenium");
Thread.sleep(2000);
driver.switchTo().alert().accept();
Thread.sleep(3000);
        driver.close();


    }
}
