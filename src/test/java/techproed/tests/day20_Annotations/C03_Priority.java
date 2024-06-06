package techproed.tests.day20_Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_Priority {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test //priority yazılmazsa default sıfır olarak çalışır
    public void testYoutube() {
        driver.get("https://youtube.com");
    }

    @Test (priority = 2)
    public void testAmazon() {
        driver.get("https://amazon.com");
    }

    @Test (priority = -1)
    public void testFacebook() {
        driver.get("https://facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}