package FailedScenarionScreenshot;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListener.class)
public class ScreenshotTest extends Base {
    @BeforeMethod
    public void setUp()
    {
initialization();
    }
    @AfterMethod
    public  void tearDown()
    {
driver.quit();
    }
    @Test
    public void takeScreenshot1()
    {
        Assert.assertEquals(false,true);
    }
    @Test
    public void takeScreenshot2()
    {
        Assert.assertEquals(false,true);
    }
}
