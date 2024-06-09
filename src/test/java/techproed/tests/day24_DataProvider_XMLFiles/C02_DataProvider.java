package techproed.tests.day24_DataProvider_XMLFiles;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_DataProvider {
    @DataProvider
    public static Object[][] accounts() {
        return new Object[][]{
                {"ayhancan@bluerentalcars.com", "ayhan"},
                {"beyhancan@bluerentalcars.com", "beyhan"},
                {"johnson@bluerentalcars.com", "johnson"}
        };
    }

/*  BlueRentalCar Sayfasına Gidelim
    Login butonuna tıklayalım
    Dataprovider Kullanarak verilen email ve password bilgileri ile login olalım
    Sayfayı kapatalım
    {"ayhancan@bluerentalcars.com", "ayhan"},
    {"beyhancan@bluerentalcars.com", "beyhan"},
    {"johnson@bluerentalcars.com", "johnson"}
*/

    @Test(dataProvider = "accounts")
    public void test01(String email, String password) {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCarsUrl"));

        BlueRentalCarsPage blueRentalCarsPage = new BlueRentalCarsPage();
        blueRentalCarsPage.loginFirst.click();

        blueRentalCarsPage.email.sendKeys(email);
        blueRentalCarsPage.password.sendKeys(password);
        blueRentalCarsPage.loginButton.submit();

        Driver.closeDriver();
    }
}