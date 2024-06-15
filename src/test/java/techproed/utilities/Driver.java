package techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
    ThreadLocal Class'ı Java'da her Thread'e özgü variable'lar saklamak için kullanılır.
    PARALEL TESTLER YAPARKEN -> ThreadLocal<WebDriver> kullanımı, Thread'ler arasında izolasyon sağlar.
    Dolayısıyla her bir thread'in kendi WebDriver objesine sahip olmasını sağlar.
    Bu sayede paralel test yaparken testlerin birbirinden bağımsı ve stabil bir şekilde çalışmasını sağlar.
     */

    // ThreadLocal ile her thread için ayrı bir WebDriver objesi oluşturuyoruz.

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {

            //WebDriver thread bazında oluşturuyoruz.
            switch (ConfigReader.getProperty("browser")) {

                case "chrome":
                    driverPool.set(new ChromeDriver());
                    break;

                case "edge":
                    driverPool.set(new EdgeDriver());
                    break;

                case "safari":
                    driverPool.set(new SafariDriver());
                    break;

                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;

                case "ie":
                    driverPool.set(new InternetExplorerDriver());
                    break;

                default:
                    driverPool.set(new ChromeDriver());
            }

            // Oluşturduğumuz WebDriver'ı yapılandırıyoruz.
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        // Thread'e özgü WebDriver objesi return ediyoruz.
        return driverPool.get();
    }

    private Driver() {
        //Singleton Pattern
    }

    public static void closeDriver() {

        //Açık olan WebDriver örneğini kapatıyoruz.
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove(); // ThreadLocal'daki referansı temizliyoruz
        }
    }
}