package techproed.tests.day22_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C04_ClassWork {

    @Test
    public void test01() {

        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage testCenterPage = new TestCenterPage();

        testCenterPage.userName.sendKeys(ConfigReader.getProperty("testCenterUserName"));
        testCenterPage.password.sendKeys(ConfigReader.getProperty("testCenterPassword"));
        testCenterPage.submitButton.submit();

        Assert.assertTrue(testCenterPage.logoutButton.isEnabled());

        //Sayfadan cikis yap ve cikis yapildigini test et
        testCenterPage.logoutButton.click();

        Assert.assertTrue(testCenterPage.submitButton.isEnabled());

        //sayfayı kapatınız
        Driver.closeDriver();
    }
}