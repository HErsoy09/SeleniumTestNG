package techproed.tests.day22_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.Driver;

public class C02_PageKullanimi {

    @Test
    public void test01() throws InterruptedException {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        //kullanici=Admin
        //kullaniciSifre=admin123

        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.userName.sendKeys("Admin");
        openSourcePage.password.sendKeys("admin123");
        openSourcePage.loginButton.submit();

        Thread.sleep(3000); //Reusable metotları denemek için yazdık

        //Login Testinin basarili oldugunu test edelim
        Assert.assertTrue(openSourcePage.loginSuccess.isEnabled());

        //sayfayı kapatalim
        Driver.closeDriver();
    }
}