package techproed.tests.day25_XMLFiles_ParallelTest;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_ParallelTest {

    @Test
    public void test01_2() {

        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("techproedUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCarsUrl"));
        Driver.closeDriver();
    }

    @Test
    public void test02_2() {

        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("techproedUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCarsUrl"));
        Driver.closeDriver();
    }
}