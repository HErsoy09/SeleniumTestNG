package techproed.tests.day23_POM_Excel;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C03_BlueRentalCarExcelTest {

    @Test
    public void test01() {

        //BlueRentalcar sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCarsUrl"));

        //Login buttonuna tıklayalım
        BlueRentalCarsPage blueRentalCarsPage = new BlueRentalCarsPage();
        blueRentalCarsPage.loginFirst.click();

        //Excel dosyasındaki herhangi bir email ve password ile login olalım
        String path = "src/test/java/techproed/resources/adminTestData.xlsx";
        String sheetName = "costumer_info";
        ExcelReader reader = new ExcelReader(path, sheetName);

        String email = reader.getCellData(1, 0);
        String password = reader.getCellData(1, 1);

        blueRentalCarsPage.email.sendKeys(email);
        blueRentalCarsPage.password.sendKeys(password);
        blueRentalCarsPage.loginButton.submit();

        //Girilen email ile giriş yapıldığını doğrulayın
        WebElement actualAlert = blueRentalCarsPage.loginVerify;
        ReusableMethods.visibleWait(actualAlert, 10);

        blueRentalCarsPage.dropDownButton.click();
        blueRentalCarsPage.profile.click();

        String profileEmail = blueRentalCarsPage.profileEmail.getAttribute("value");

        Assert.assertEquals(profileEmail, email);

        //sayfayı kapatalım
        Driver.closeDriver();
    }
}