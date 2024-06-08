package techproed.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.PanelUI;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

    // HARD WAIT METHOD
    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // ALERT ACCEPT
    public static void alertAccept() {
        Driver.getDriver().switchTo().alert().accept();
    }

    // ALERT DISMISS
    public static void alertDismiss() {
        Driver.getDriver().switchTo().alert().dismiss();
    }

    // ALERT getText()
    public static void alertText() {
        Driver.getDriver().switchTo().alert().getText();
    }

    // ALERT promptBox
    public static void alertPrompt(String text) {
        Driver.getDriver().switchTo().alert().sendKeys(text);
    }

    // Dropdown VisibleText
    /*
    Select select2 = new Select(day);
    select2.selectByVisibleText("7");
    ddmVisibleText(day, "7"); // Yukarıdaki kullanım yerine sadece metot ile handle edilebilir.
    */

    // DROPDOWN visibleText
    public static void ddmVisibleText(WebElement ddm, String option) {
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    // DROPDOWN index
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    // DROPDOWN Value
    public static void ddmValue(WebElement ddm, String value) {
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    // SWITCHtoWINDOW 1
    public static void switchToWindow1(int number) {
        List<String> allWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(allWindowHandles.get(number));
    }

    // SWITCHtoWINDOW 2
    public static void switchToWindow2(int number) {
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[number].toString());
    }

    // EXPLICIT WAIT METHODS
    //Visible Wait
    public static void visibleWait(WebElement element, int number) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(number));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Alert Wait
    public static void alertWait(int number) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(number));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    // All Page ScreenShot
    public static void screenShot(String name) {
        String date = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(LocalDateTime.now());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        String path = System.getProperty("user.dir") + "/src/test/java/techproed/testOutputs/screenshots/" + name + date + ".jpg";
        try {
            Files.write(Paths.get(path), ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // WebElement ScreenShot
    public static void screenShotOfWebElement(WebElement webElement) {
        String date = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(LocalDateTime.now());
        String path = System.getProperty("user.dir") + "/src/test/java/techproed/testOutputs/webElementScreenshots/" + date + ".jpg";
        try {
            Files.write(Paths.get(path), webElement.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //WebTable
//    public static void printData(int row, int column) {
//        WebElement table = Driver.getDriver().findElement(By.xpath())
//    }

}