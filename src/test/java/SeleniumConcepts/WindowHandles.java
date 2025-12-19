package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.programiz.com/java-programming/online-compiler/");
        String parentwindow=driver.getWindowHandle();
        System.out.println(parentwindow);
        driver.findElement(By.xpath("//a[contains(text(),'Programiz PRO')]\n")).click();
        Thread.sleep(2000);
        Set<String> windowHandles= driver.getWindowHandles();
        List<String> list= new ArrayList<String>(windowHandles);
        driver.switchTo().window(list.get(1));
        Thread.sleep(15000);
        System.out.println(driver.getTitle());
        driver.switchTo().window(list.get(0));
        System.out.println(driver.getTitle());

        Thread.sleep(2000);

        driver.quit();

    }

}
