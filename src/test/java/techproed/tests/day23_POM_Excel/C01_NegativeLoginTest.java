package techproed.tests.day23_POM_Excel;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_NegativeLoginTest {

    //Name:
    //US100208_Negative_Login
    //Description:
    //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapılamamali
    //Acceptance Criteria
    //Customer email: fake@bluerentalcars.com
    //Customer password: fakepass
    //Error:
    //User with email fake@bluerentalcars.com not found

    @Test
    public void negativeTest() {

        //BlueRentalCar sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCarsUrl"));

        //Login buttonuna tıklayalım
        BlueRentalCarsPage blueRentalCarsPage = new BlueRentalCarsPage();
        blueRentalCarsPage.loginFirst.click();

        //Properties dosyasındaki kullanımda olmayan email ve password bilgileri ile login olamadığını test edelim
        blueRentalCarsPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"));
        blueRentalCarsPage.password.sendKeys(ConfigReader.getProperty("fakePassword"));
        blueRentalCarsPage.loginButton.submit();

        WebElement actualAlert = blueRentalCarsPage.toastifyMessageNegative;
        ReusableMethods.visibleWait(actualAlert, 10);

        String expectedAlertText = "User with email " + ConfigReader.getProperty("fakeEmail") + " not found";
        Assert.assertEquals(actualAlert.getText(), expectedAlertText);

        //sayfayı kapatınız
        Driver.closeDriver();
    }
}