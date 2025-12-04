import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testng {

    @Test
    public void testA()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.vskills.in/interview-questions/playwright-interview-questions");
    }
    @Test
    public void testB()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://chatgpt.com/");
    }
    @Test
    public void testc()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.youtube.com/watch?v=K4MZqwYktUs&list=PLLS0D9-W-1dmoSD9D-h0LxLSytAgyGDSB");
    }
}



