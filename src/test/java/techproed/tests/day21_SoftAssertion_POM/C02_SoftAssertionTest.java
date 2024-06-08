package techproed.tests.day21_SoftAssertion_POM;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C02_SoftAssertionTest {

    @Test
    public void test01() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- amazon anasayfaya gidin
        driver.get("https://amazon.com");

        // 2- title'in Amazon icerdigini test edin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getTitle().contains("rAmazon"), "Title rAmazon içermiyor");

        // 3- Arama kutusunun erisilebilir oldugunu test edin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(searchBox.isEnabled(), "Arama kutusu erişilebilir değil");

        // 4- arama kutusuna selenium yazip aratin
        searchBox.sendKeys("selenium", Keys.ENTER);

        // 5- arama yapildigini test edin
        softAssert.assertTrue(driver.getTitle().contains("selenium"), "Arama yapılamadı");

        // 6- arama sonucunun selenium icerdigini test edin
        softAssert.assertTrue(driver.findElement(By.cssSelector("div.sg-col-inner>.a-section.a-spacing-small.a-spacing-top-small")).getText().contains("slenium"), "Arama sonucunda slenium yok");

        softAssert.assertAll(); //UNUTMAMALIYIZ!!!

        driver.quit();
    }
}