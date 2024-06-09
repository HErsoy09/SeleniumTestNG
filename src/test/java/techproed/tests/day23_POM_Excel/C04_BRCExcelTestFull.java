package techproed.tests.day23_POM_Excel;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C04_BRCExcelTestFull {

    @Test
    public void test01() {

        // BRC sayfasına git
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCarsUrl"));

        // Excel dosyasındaki tüm verilerle login ol, doğrula
        String path = "src/test/java/techproed/resources/adminTestData.xlsx";
        String sheetName = "costumer_info";
        ExcelReader reader = new ExcelReader(path, sheetName);

        BlueRentalCarsPage blueRentalCarsPage = new BlueRentalCarsPage();

        for (int i = 1; i <= reader.rowCount(); i++) {
            String email = reader.getCellData(i, 0);
            String password = reader.getCellData(i, 1);

            blueRentalCarsPage.loginFirst.click();
            blueRentalCarsPage.email.sendKeys(email);
            blueRentalCarsPage.password.sendKeys(password);
            blueRentalCarsPage.loginButton.submit();

            blueRentalCarsPage.loginVerify.click();
            Assert.assertTrue(blueRentalCarsPage.profile.isEnabled());

            blueRentalCarsPage.logout.click();
            blueRentalCarsPage.okButtton.click();

            ReusableMethods.wait(1);
        }

        Driver.closeDriver();
    }
}