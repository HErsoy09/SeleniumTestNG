package techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    static WebDriver driver;

    private Driver() {
        /*
        POM'da Driver Class'ındaki getDriver() metodunu object oluşturarak kullanılmasını engellemek için Singleton Pattern kullanımı benimsenmiştir.
        Singleton Pattern (Tekli Kullanım): Bir calss'tan object oluşturulmasını engelleyerek o class'tan özelliklere erişimi tekli yaparız.
        Bunu sağlamak için default constructor private yapılır.
        */
    }

    public static WebDriver getDriver() {

        /*
         Driver her çalıştığında yeni pencereler açmasın, tek bir driver üzerinden devam etsin diye if bloğu içine konuldu
         Yapmış olduğumuz ayarlamada driver'a değer atanmamış ise başlatılacak, driver açıkken tekrar çağrılırsa yeniden çalıştırmadan, mevcut driver üzerinden devam edecek
        */

        if (driver == null) {

            switch (ConfigReader.getProperty("browser")) {

                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    driver = new SafariDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                case "ie":
                    driver = new InternetExplorerDriver();
                    break;

                default:
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {

        if (driver != null) {
            driver.close();
            driver = null; //Session (kaynaklar) kapatmak için
        }
    }
}