package techproed.tests.day24_DataProvider_XMLFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DataProviderPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.DataProviderUtils;
import techproed.utilities.Driver;

public class C03_DataProviderUtils {

    // https://dataprovider.netlify.app/ adresine git
    // BlackBoxTesting tekniği ile otomasyon testi yap

    @Test(dataProvider = "positiveTestData", dataProviderClass = DataProviderUtils.class)
    public void test01(Integer age) {

        Driver.getDriver().get(ConfigReader.getProperty("dataProviderUrl"));

        DataProviderPage dataProviderPage = new DataProviderPage();
        dataProviderPage.searchBox.sendKeys(String.valueOf(age), Keys.TAB, Keys.ENTER);

        Assert.assertTrue(dataProviderPage.positiveVerifyMessage.isDisplayed());

        Driver.closeDriver();
    }

    @Test(dataProvider = "negativeTestData", dataProviderClass = DataProviderUtils.class)
    public void test02(Integer age) {

        Driver.getDriver().get(ConfigReader.getProperty("dataProviderUrl"));

        DataProviderPage dataProviderPage = new DataProviderPage();
        dataProviderPage.searchBox.sendKeys(String.valueOf(age), Keys.TAB, Keys.ENTER);

        String result = dataProviderPage.negativeVerifyMessage.getText();
        if (result == "Geçersiz yaş!" || result == "Yaş 18 ile 100 arasında olmalıdır.") {
            result = result;
        }

        Assert.assertTrue(!result.isEmpty());

        Driver.closeDriver();
    }
}