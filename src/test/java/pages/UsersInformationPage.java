package pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import utils.Utils;



import java.util.List;

public class UsersInformationPage {
    @FindBy(className = "oxd-main-menu-item")
    public List<WebElement> userMenu;
    @FindBy(className = "oxd-radio-input")
    public List<WebElement> btnRadio;
    @FindBy(className = "oxd-select-text-input")
    public List<WebElement> dropdown;
    @FindBy(className = "orangehrm-tabs-item")
    public List<WebElement> contactDetails;
    @FindBy(className = "oxd-input")
    public List<WebElement> txtInput;
    @FindBy(className = "oxd-select-text-input")
    public WebElement dropdownCountry;
    @FindBy(css = "[type=submit]")
    public List<WebElement> Submit;
    public UsersInformationPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    public void selectGender() throws InterruptedException {

        btnRadio.get(1).click();
        Thread.sleep(1500);
        Submit.get(0).click();
    }
    public void selectBloodType() throws InterruptedException {
        dropdown.get(2).click();
        dropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        dropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        dropdown.get(2).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        Submit.get(1).click();
    }


    public void selectContact() throws InterruptedException {

        contactDetails.get(1).click();
        Thread.sleep(1500);
        Faker faker =new Faker();
        String streetAddress=faker.address().streetAddress();
        txtInput.get(1).sendKeys(streetAddress);
        txtInput.get(2).sendKeys(streetAddress);
        String city =faker.address().city();
        txtInput.get(3).sendKeys(city);
        String state=faker.address().state();
        txtInput.get(4).sendKeys(state);
        String postalCode=faker.address().zipCode();
        txtInput.get(5).sendKeys(postalCode);
        Thread.sleep(1500);
        dropdownCountry.click();
        dropdownCountry.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1500);
        dropdownCountry.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1500);
        dropdownCountry.sendKeys(Keys.ENTER);
        Thread.sleep(1500);
        txtInput.get(7).sendKeys("+18143008329");
        String email = "user"+Utils.generateRandomNumber(100, 999)+"@gmail.com";
        txtInput.get(9).sendKeys(email);
        Thread.sleep(1500);
        Submit.get(0).click();
    }
}
