package techproed.tests.day22_POM;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.Driver;

public class C01_PageKullanimi {

    @Test
    public void test01() {

        //Amazon sayfasına git
        Driver.getDriver().get("https://amazon.com");

        //arama kutusunda selenium arat
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searchBox.sendKeys("selenium", Keys.ENTER);
    }
}