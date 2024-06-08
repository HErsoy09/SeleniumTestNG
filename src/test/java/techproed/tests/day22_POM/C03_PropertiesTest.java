package techproed.tests.day22_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_PropertiesTest {

    @Test
    public void test01() {

        String url = ConfigReader.getProperty("amazonUrl");
        System.out.println(url);
    }

    @Test
    public void test02() throws InterruptedException {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSourceUrl"));

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.userName.sendKeys(ConfigReader.getProperty("openSourceUserName"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("openSourcePassword"));
        openSourcePage.loginButton.submit();

        ReusableMethods.visibleWait(openSourcePage.loginSuccess, 15);

        //Login Testinin basarili oldugunu test edelim
        Assert.assertTrue(openSourcePage.loginSuccess.isEnabled());
        ReusableMethods.screenShot("OpenSource");
        ReusableMethods.screenShotOfWebElement(openSourcePage.loginSuccess);

        //sayfayı kapatalim
        Driver.closeDriver();
    }
}