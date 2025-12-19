package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");
        //enter text inside single frame
        driver.switchTo().frame("singleframe");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("hi");
driver.switchTo().defaultContent();
driver.findElement(By.xpath("//a[contains(normalize-space(), 'Iframe with in an Iframe')]\n")).click();

    }
}
