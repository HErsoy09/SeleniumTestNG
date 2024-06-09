package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalCarsPage {

    public BlueRentalCarsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.=\' Login\']")
    public WebElement loginFirst;

    @FindBy(id = "formBasicEmail")
    public WebElement email;

    @FindBy(id = "formBasicPassword")
    public WebElement password;

    @FindBy(xpath = "//div[@class='card-body']//button")
    public WebElement loginButton;

    @FindBy(id = "dropdown-basic-button")
    public WebElement loginVerify;

    //---

    //@FindBy(xpath = "//*[contains( text(), \"User with\")]")
    @FindBy(css = ".Toastify__toast-body>div")
    public  WebElement toastifyMessageNegative;

    @FindBy(id = "dropdown-basic-button")
    public WebElement dropDownButton;

    @FindBy(xpath = "//*[@class='dropdown-menu show dropdown-menu-end']/a[.='Profile']")
    public WebElement profile;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement profileEmail;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logout;

    @FindBy(xpath = "//*[.='OK']")
    public WebElement okButtton;
}