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
    @FindBy(id = "logout-btn") WebElement logoutbtn_id;

    public  LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyLoginpageIsDisplayed()throws InterruptedException{
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(loginpagetitle_id));
        loginpagetitle_id.isDisplayed();
        Thread.sleep(2000);
    }
    public void enterEmail(String email)throws InterruptedException{
        email_id.clear();
        email_id.sendKeys(email);
        Thread.sleep(2000);
    }
    public void enterPassword(String password)throws InterruptedException{
        password_id.sendKeys(password);
        Thread.sleep(2000);
    }
    public void loginButtonSubmit()throws InterruptedException{
        loginsubmit_id.click();
        Thread.sleep(2000);
    }
    public void logoutButtonClick()throws InterruptedException{
        logoutbtn_id.click();
        Thread.sleep(2000);
    }

}
