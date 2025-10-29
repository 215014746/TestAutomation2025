package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
