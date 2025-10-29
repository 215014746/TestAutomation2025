package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "login-heading") WebElement loginpagetitle_id;
    @FindBy(id = "login-email") WebElement email_id;
    @FindBy(id = "login-password") WebElement password_id;
    @FindBy(id = "login-submit") WebElement loginsubmit_id;

    public  LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyLoginpageIsDisplayed(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(loginpagetitle_id));
        loginpagetitle_id.isDisplayed();
    }
    public void enterEmail(String email){
        email_id.sendKeys(email);
    }
    public void enterPassword(String password){
        password_id.sendKeys(password);
    }
    public void loginButtonSubmit(){
        loginsubmit_id.click();
    }

}
