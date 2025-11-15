package Tests;


import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
@Test
public class AllTests extends Base {

//HomePage
    public void verifyHomePageIsDisplayedTest()throws InterruptedException {
        homePage.verifyHomePageIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyHomePageIsDisplayedTest")
    public void clickLearningMaterialTest()throws InterruptedException {
        homePage.clickLearningMaterial();
        takeScreenshots.takesSnapshot(driver, "LearningMaterialPage");
    }
    //SignupPage
    @Test(dependsOnMethods = "clickLearningMaterialTest")
    public void clickSignupToggleTest()throws InterruptedException {
        SignupPage.clickSignupToggle();
    }
    @Test(dependsOnMethods = "clickSignupToggleTest")
    public void verifySignupPageIsDisplayedTest()throws InterruptedException {
        SignupPage.verifySignupPageIsDisplayed();
    }
    //Password mismatch scenario
    @Test(dependsOnMethods = "verifySignupPageIsDisplayedTest", priority = 1)
    public void passwordMismatchTest() throws InterruptedException {

        SignupPage.enterFirstName("Zinhle");
        SignupPage.enterLastName("Ndubane");
        SignupPage.enterEmail(SignupPage.generateUniqueEmail());
        SignupPage.enterPassword("Password123");
        SignupPage.enterConfirmPassword("Wrong123");
        SignupPage.clickRegisterSubmit();
        Thread.sleep(500);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("ALERT: " + alertText);
        Assert.assertEquals(alertText, "Passwords do not match!");
        alert.accept();
    }
   @Test(priority = 2)
    public void invalidEmailFormatTest() throws InterruptedException {

        SignupPage.enterFirstName("Zinhle");
        SignupPage.enterLastName("Ndubane");
        SignupPage.enterEmail("zinhle.ndubane.com");
        SignupPage.enterPassword("Password123");
        SignupPage.enterConfirmPassword("Password123");
        SignupPage.clickRegisterSubmit();
        Thread.sleep(500);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("ALERT: " + alertText);
        Assert.assertEquals(alertText, "Please enter a valid email address");
        alert.accept();
    }
    @Test(priority = 3)
    public void passwordTooShortTest() throws InterruptedException {

        SignupPage.enterFirstName("Zinhle");
        SignupPage.enterLastName("Ndubane");
        SignupPage.enterEmail(SignupPage.generateUniqueEmail());
        SignupPage.enterPassword("Pass123");
        SignupPage.enterConfirmPassword("Pass123");
        SignupPage.clickRegisterSubmit();
        Thread.sleep(500);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("ALERT: " + alertText);
        Assert.assertEquals(alertText, "Password must be at least 8 characters long");
        alert.accept();
    }
    @Test(priority = 3)
    public void successfulRegistrationTest() throws InterruptedException {

        SignupPage.enterFirstName("Zinhle");
        SignupPage.enterLastName("Ndubane");
        SignupPage.enterEmail(SignupPage.generateUniqueEmail());
        SignupPage.enterPassword("Password123");
        SignupPage.enterConfirmPassword("Password123");
        SignupPage.clickRegisterSubmit();
        Thread.sleep(500);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("ALERT: " + alertText);
        Assert.assertEquals(alertText, "Registration successful! You can now login with your credentials.");
        alert.accept();

    }
    //LoginPage
    @Test(priority = 4, dependsOnMethods = "successfulRegistrationTest")
    public void verifyLoginpageIsDisplayedTest()throws InterruptedException {
        loginPage.verifyLoginpageIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyLoginpageIsDisplayedTest")
    public void invalidCredentialsTest() throws InterruptedException{
        loginPage.enterEmail("zee2025@ndosi");
        loginPage.enterPassword("Zee@2025");
        loginPage.loginButtonSubmit();
        Thread.sleep(500);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("ALERT: " + alertText);
        Assert.assertEquals(alertText, "Invalid email or password");
        alert.accept();

    }
    @Test(priority = 5)
    public void extraSpacesInCredentialsTest() throws InterruptedException{
        loginPage.enterEmail("  zee2025@ndosi.com  ");
        loginPage.enterPassword("  Zee@2025  ");
        loginPage.loginButtonSubmit();
        Thread.sleep(500);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String token = (String) js.executeScript("return window.localStorage.getItem('authToken');");
        Assert.assertNotNull(token, "Auth token should exist after login with spaces");

    }
    @Test(priority = 6)
    public void logoutTest() throws InterruptedException{
        loginPage.logoutButtonClick();
        Thread.sleep(500);
    }
    @Test(priority = 7)
    public void forcedLogoutOnTabSwitchTest() throws InterruptedException{
        loginPage.enterEmail("zee2025@ndosi.com");
        loginPage.enterPassword("Zee@2025");
        loginPage.loginButtonSubmit();
        Thread.sleep(500);

        ((JavascriptExecutor) driver).executeScript("window.open('https://mvnrepository.com/search?q=list');");
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

        String token = (String) ((JavascriptExecutor) driver).executeScript("return window.localStorage.getItem('authToken');");
        Assert.assertNull(token, "Token should be removed after forced logout");

    }


    //LearningMaterialPage
    @Test(dependsOnMethods = "forcedLogoutOnTabSwitchTest")
   public void verifyLearningMaterialPageIsDisplayedTest()throws InterruptedException {
        learningMaterialPage.verifyLearningMaterialPageIsDisplayed();
    }
   @Test(dependsOnMethods = "verifyLearningMaterialPageIsDisplayedTest")
   public void clickWebAutomationFormTest()throws InterruptedException {
       learningMaterialPage.clickWebAutomationAdvanceTab();
    }

    //WebAutomationAdvanceTab
    @Test(dependsOnMethods = "clickWebAutomationFormTest")
    public void verifyInventoryHeaderIsDisplayedTest()throws InterruptedException {
        webAutomationAdvanceTab.verifyInventoryHeaderIsDisplayed();
    }

     @Test(dependsOnMethods = "verifyInventoryHeaderIsDisplayedTest")
    public void selectPhoneTest()throws InterruptedException {
        webAutomationAdvanceTab.selectDeviceType("Phone");
    }
    @Test(dependsOnMethods = "selectPhoneTest")
    public void selectBrandTest()throws InterruptedException {
        webAutomationAdvanceTab.selectBrand("Apple");
    }
   @Test(dependsOnMethods = "selectBrandTest")
    public void selectStorageTest() throws InterruptedException{
        webAutomationAdvanceTab.selectStorage("128GB");
    }
    @Test(dependsOnMethods = "selectStorageTest")
    public void enterColorTest()throws InterruptedException {
        webAutomationAdvanceTab.enterColor("black");
    }
    @Test(dependsOnMethods = "enterColorTest")
    public void enterQuantityTest()throws InterruptedException  {

        webAutomationAdvanceTab.enterQuantity("1");
    }
    @Test(dependsOnMethods = "enterQuantityTest")
    public void enterAddressTest()throws InterruptedException {
        webAutomationAdvanceTab.enterAddress("123 Main St, Cityville");
    }
    @Test(dependsOnMethods = "enterAddressTest")
    public void clickNextbuttonTest()throws InterruptedException {
        webAutomationAdvanceTab.clickNextButton();
    }
    @Test(dependsOnMethods = "clickNextbuttonTest")
    public void selectShippingOptionsTest() throws InterruptedException{
        webAutomationAdvanceTab.selectShippingOption("express");
    }
    @Test(dependsOnMethods = "selectShippingOptionsTest")
    public void selectWarrantyOptionsTest()throws InterruptedException {
        webAutomationAdvanceTab.selectWarrantyOptions("2yr");
    }
    @Test(dependsOnMethods = "selectWarrantyOptionsTest")
    public void enterDiscountCodeTest()throws InterruptedException {
        webAutomationAdvanceTab.enterDiscountCode("SAVE10");
    }
    @Test(dependsOnMethods = "enterDiscountCodeTest")
    public void clickApplyDiscountButtonTest()throws InterruptedException {
        webAutomationAdvanceTab.clickApplyDiscountButton();
    }
    @Test(dependsOnMethods = "clickApplyDiscountButtonTest")
    public void verifyPreviewPageIsDisplayedTest() throws InterruptedException{
        webAutomationAdvanceTab.verifyPreviewPageIsDisplayed();
   }
    @Test(dependsOnMethods = "clickApplyDiscountButtonTest")
    public void verifyPricingSummaryIsDisplayedTest() throws InterruptedException{
        webAutomationAdvanceTab.verifyPricingSummaryIsDisplayed();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    @Test(dependsOnMethods = "verifyPricingSummaryIsDisplayedTest")
    public void clickAddToCartButtonTest()throws InterruptedException {
       webAutomationAdvanceTab.clickAddToCartButton();
    }

    //Add another device to cart

    @Test(dependsOnMethods = "clickAddToCartButtonTest")
    public void selectTabletTest() throws InterruptedException{
        webAutomationAdvanceTab.selectDeviceType("Tablet");
    }
    @Test(dependsOnMethods = "selectTabletTest")
    public void selectSamsungTest()throws InterruptedException {
        webAutomationAdvanceTab.selectBrand("Samsung");
    }
    @Test(dependsOnMethods = "selectSamsungTest")
    public void selectStorageDeviceTwoTest() throws InterruptedException{
        webAutomationAdvanceTab.selectStorage("256GB");
    }
    @Test(dependsOnMethods = "selectStorageDeviceTwoTest")
    public void enterColorDeviceTwoTest() throws InterruptedException{
        webAutomationAdvanceTab.enterColor("blue");
    }
    @Test(dependsOnMethods = "enterColorDeviceTwoTest")
    public void enterQuantityDeviceTwoTest() throws InterruptedException {

        webAutomationAdvanceTab.enterQuantity("1");
    }
    @Test(dependsOnMethods = "enterQuantityDeviceTwoTest")
    public void enterAddressDeviceTwoTest()throws InterruptedException {
        webAutomationAdvanceTab.enterAddress("123 Main St, Cityville");
    }
    @Test(dependsOnMethods = "enterAddressDeviceTwoTest")
    public void clickNextbuttonDeviceTwoTest()throws InterruptedException {
        webAutomationAdvanceTab.clickNextButton();
    }
    @Test(dependsOnMethods = "clickNextbuttonDeviceTwoTest")
    public void selectShippingOptionsDeviceTwoTest()throws InterruptedException {
        webAutomationAdvanceTab.selectShippingOption("standard");
    }

     @Test(dependsOnMethods = "selectShippingOptionsDeviceTwoTest")
    public void selectWarrantyOptionstwoTest()throws InterruptedException {
        webAutomationAdvanceTab.selectWarrantyOptions("1yr");
    }
   @Test(dependsOnMethods = "selectWarrantyOptionstwoTest")
    public void clickAddToCartButtonDeviceTwoTest()throws InterruptedException {
        webAutomationAdvanceTab.clickAddToCartButton();
    }
    @Test(dependsOnMethods = "clickAddToCartButtonDeviceTwoTest")
    public void clickReviewCartButtonTest()throws InterruptedException {
        webAutomationAdvanceTab.clickReviewCartButton();
    }
    @Test(dependsOnMethods = "clickReviewCartButtonTest")
    public void verifyCartItemsIsDisplayedTest()throws InterruptedException {
        webAutomationAdvanceTab.verifyCartItemsIsDisplayed();
    }
    @Test(dependsOnMethods = "verifyCartItemsIsDisplayedTest")
    public void clickConfirmCartButtonTest()throws InterruptedException {
        webAutomationAdvanceTab.clickConfirmCartButton();
    }
//    @Test(dependsOnMethods = "clickConfirmCartButtonTest")
//    public void clickPurchaseButtonTest()throws InterruptedException {
//        webAutomationAdvanceTab.clickPurchaseButton();
//    }
    @Test(dependsOnMethods = "clickConfirmCartButtonTest")
    public void clickViewInvoiceButtonTest()throws InterruptedException {
        webAutomationAdvanceTab.clickViewInvoiceButton();
    }
@Test(dependsOnMethods = "clickViewInvoiceButtonTest")
    public void clickLatestInvoiceViewTest()throws InterruptedException {
        webAutomationAdvanceTab.clickLatestInvoiceView();
    }
    @Test(dependsOnMethods = "clickLatestInvoiceViewTest")
    public void clickLatestInvoiceDownloadTest()throws InterruptedException {
        webAutomationAdvanceTab.clickLatestInvoiceDownload();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
