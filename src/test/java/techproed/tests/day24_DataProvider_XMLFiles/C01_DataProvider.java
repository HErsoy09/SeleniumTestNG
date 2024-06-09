package techproed.tests.day24_DataProvider_XMLFiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_DataProvider {

    @DataProvider // Bu alana (name="GoogleUrunler") eklersek ve @Test alanındaki alana da bu isim yazılırsa, sadece o teste özel olur ve başka testlerde çalışmaz
    public static Object[][] products() {
        return new Object[][]{
                {"laptop"}, {"printer"}, {"mouse"}, {"keyboard"}
        };
    }

    @Test(dataProvider = "products")
    public void test01(String data) {

        // Google sayfasına git
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        // DataProvider ile istenilen ürün isimlerini arat
        GooglePage googlePage = new GooglePage();
        googlePage.searchBox.sendKeys(data, Keys.ENTER);

        // Sayfayı kapat
        Driver.closeDriver();
    }

    @Test(dataProvider = "products")
    public void test02(String data) {

        // Amazon sayfasına git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // DataProvider ile istenilen ürün isimlerini arat
        AmazonPage amazonPage = new AmazonPage();

/*        try {
            amazonPage.handleCaptcha();
        } catch (Exception e) {
            // Sayfada captcha çıkmazsa NoSuchElementException almamak için bu kod ile ignore ettik
        }*/

        amazonPage.searchBox.sendKeys(data, Keys.ENTER);

        // Sayfayı kapat
        Driver.closeDriver();
    }
}