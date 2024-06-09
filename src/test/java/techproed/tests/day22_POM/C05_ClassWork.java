package techproed.tests.day22_POM;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C05_ClassWork {
    @Test
    public void test01() {

        //Name: US100201_Admin_Login
        //Description:
        //Admin bilgileriyle giris
        //Acceptance Criteria:
        //Admin olarak, uygulamaya giriş yapabilmeliyim
        //email: ada@ada.com
        //password: 12345
        //https://www.bluerentalcars.com/

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCarsUrl"));

        BlueRentalCarsPage blueRentalCarsPage = new BlueRentalCarsPage();

        blueRentalCarsPage.loginFirst.click();
        blueRentalCarsPage.email.sendKeys(ConfigReader.getProperty("blueRentalCarsEmail"));
        blueRentalCarsPage.password.sendKeys(ConfigReader.getProperty("blueRentalCarsPassword"));
        blueRentalCarsPage.loginButton.submit();

        Assert.assertTrue(blueRentalCarsPage.loginVerify.isEnabled());

        Driver.closeDriver();
    }
}