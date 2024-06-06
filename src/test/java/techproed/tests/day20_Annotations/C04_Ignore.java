package techproed.tests.day20_Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_Ignore {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //Bir testin çalışmasını istemiyorsak;
    @Test @Ignore
    public void testYoutube() {
        driver.get("https://youtube.com");
    }

    @Ignore
    @Test
    public void testAmazon() {
        driver.get("https://amazon.com");
    }

    @Test (enabled = false) //Default olarak true, false olduğunda test devredışı olur
    public void testFacebook() {
        driver.get("https://facebook.com");
    }

    @Test
    public void testYahoo() {
        driver.get("https://yahoo.com");

        Boolean excelPath = false;
        if (excelPath) {
            System.out.println("Test çalışır.");
        } else {
            throw new SkipException("Excel dosya yolu hatalı veya dosya silinmiş");
            //Belirli bir durumda test iptal edilebilir. Örneğin excel dosya yolu hatalı olursa gibi
            //Runtime'da dynamic olarak durdurulmuş olur.
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}