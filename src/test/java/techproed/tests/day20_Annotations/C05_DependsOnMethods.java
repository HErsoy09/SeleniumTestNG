package techproed.tests.day20_Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_DependsOnMethods {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {

        //Amazon
        driver.get("https://amazon.com");

        //Selenium arat
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium", Keys.ENTER);
    }

    @Test (dependsOnMethods = "test01") //Bağlı olunan testin sonucu Pass olursa aktive olur, fail olursa çalışmaz
    public void test02() {

        //Sonuç yazısında selenium içerdiğini test et
        String resultText = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']")).getText();
        Assert.assertTrue(resultText.contains("selenium"));
    }
}