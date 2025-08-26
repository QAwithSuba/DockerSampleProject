package simpleLoginTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	private WebDriver driver;

    @BeforeClass
    public void setUp() {
     
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless=new");         // Run in headless mode
    	options.addArguments("--no-sandbox");           // Required in container
    	options.addArguments("--disable-dev-shm-usage"); // Avoid /dev/shm issues
    	driver = new ChromeDriver(options);

    }

    @Test
    public void openExampleDotCom() {
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"), "Title should contain 'Google'");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
