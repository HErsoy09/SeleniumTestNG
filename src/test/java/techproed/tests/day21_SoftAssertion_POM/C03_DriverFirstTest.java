package techproed.tests.day21_SoftAssertion_POM;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class C03_DriverFirstTest {

    @Test
    public void test01() {

        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://google.com");
        Driver.getDriver().get("https://facebook.com");
    }
}