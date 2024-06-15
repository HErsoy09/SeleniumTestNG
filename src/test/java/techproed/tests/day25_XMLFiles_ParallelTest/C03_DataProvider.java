package techproed.tests.day25_XMLFiles_ParallelTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_DataProvider {

    @DataProvider(parallel = true)
    public static Object[][] accounts() {
        return new Object[][]{
                {"ayhancan@bluerentalcars.com", "ayhan"},
                {"beyhancan@bluerentalcars.com", "beyhan"},
                {"johnson@bluerentalcars.com", "johnson"}
        };
    }

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