package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebAutomationFormClass {
    WebDriver driver;

    @BeforeTest
    public void launchBrowser(){
       driver = new ChromeDriver();
    }

    @Test
    public void startBrowser() throws InterruptedException{
        driver.get("https://www.ndosiautomation.co.za/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void verifyHomePageDisplay() {
        driver.findElement(By.xpath("//*[@id=\"overview-hero\"]/h2")).isDisplayed();
    }

    @Test(priority = 2)
    public void clickLearningMaterial() throws InterruptedException{
        driver.findElement(By.id("nav-btn-practice")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void enterUsername(){
        driver.findElement(By.id("login-email")).sendKeys("zee2025@ndosi.com");
    }

    @Test(priority = 4)
    public void enterPassword(){
        driver.findElement(By.id("login-password")).sendKeys("Zee@2025");
    }

    @Test(priority = 5)
    public void loginButtonSubmit() throws InterruptedException{
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void clickWebAutomationForm() throws InterruptedException{
        driver.findElement(By.id("tab-btn-password")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void enterFullName(){
        driver.findElement(By.id("name")).sendKeys("Zinhle Ndubane");
    }

    @Test(priority = 8)
    public void enterEmailAddress(){
        driver.findElement(By.id("email")).sendKeys("zee2025@ndosi.com");
    }

    @Test(priority = 9)
    public void enterAge(){
        driver.findElement(By.id("age")).sendKeys("22");
    }

    @Test(priority = 10)
    public void enterGender(){
        driver.findElement(By.id("gender")).sendKeys("Female");
    }

    @Test(priority = 11)
    public void enterCountry(){
        driver.findElement(By.id("country")).sendKeys("South Africa");
    }

    @Test(priority = 12)
    public void enterExperience(){
        driver.findElement(By.id("experience")).sendKeys("Intermediate (2-5 years)");
    }

    @Test(priority = 13)
    public void clickSkill(){
        driver.findElement(By.id("skill-java")).click();
    }

    @Test(priority = 14)
    public void enterComments() {
        driver.findElement(By.id("comments")).sendKeys("All my comments go here");

    }

    @Test(priority = 15)
    public void clickNewsletter(){
        driver.findElement(By.id("newsletter")).click();
    }

    @Test(priority = 16)
    public void clickTermsAndConditions(){
        driver.findElement(By.id("terms")).click();
    }//success-alert-btn

    @Test(priority = 17)
    public void clickSubmitForm() throws InterruptedException{
        driver.findElement(By.id("submit-btn")).click();
        Thread.sleep(7000);
    }

    @Test(priority = 18)
    public void clickValidateButton() throws InterruptedException{
        driver.findElement(By.id("success-alert-btn")).click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
