package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage {

    WebDriver driver;
    @FindBy(id = "signup-toggle")WebElement signuptoggle_id;
    @FindBy(id = "registration-heading") WebElement registrationheading_id;
    @FindBy(id = "register-firstName") WebElement registerfirstname_id;
    @FindBy(id = "register-lastName") WebElement registerlastname_id;
    @FindBy(id = "register-email") WebElement registeremail_id;
    @FindBy(id = "register-password") WebElement registerpassword_id;
    @FindBy(id = "register-confirmPassword") WebElement registerconfirmpassword_id;
    @FindBy(id = "register-submit") WebElement registersubmit_id;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickSignupToggle()throws InterruptedException {
        signuptoggle_id.click();
        Thread.sleep(2000);
    }
    public void verifySignupPageIsDisplayed()throws InterruptedException{
        registrationheading_id.isDisplayed();
        Thread.sleep(2000);
    }
    public void enterFirstName(String firstname)throws InterruptedException {
        registerfirstname_id.clear();
        registerfirstname_id.sendKeys(firstname);
        Thread.sleep(2000);
    }
    public void enterLastName(String lastname)throws InterruptedException {
        registerlastname_id.clear();
        registerlastname_id.sendKeys(lastname);
        Thread.sleep(2000);
    }
    public void enterEmail(String email)throws InterruptedException {
        registeremail_id.clear();
        registeremail_id.sendKeys(email);
        Thread.sleep(2000);
    }
    public void enterPassword(String password)throws InterruptedException {
        registerpassword_id.clear();
        registerpassword_id.sendKeys(password);
        Thread.sleep(2000);
    }
    public void enterConfirmPassword(String confirmpassword)throws InterruptedException {
        registerconfirmpassword_id.clear();
        registerconfirmpassword_id.sendKeys(confirmpassword);
        Thread.sleep(2000);
    }
    public void clickRegisterSubmit()throws InterruptedException {
        registersubmit_id.click();
        Thread.sleep(2000);
    }
    // Generate NEW email each run
    public String generateUniqueEmail() {
        long timestamp = System.currentTimeMillis();
        return "user" + timestamp + "@mail.com";
    }

}
