package Tests;


import org.openqa.selenium.JavascriptExecutor;
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
    }

    //LoginPage
    @Test(dependsOnMethods = "clickLearningMaterialTest")
    public void verifyLoginpageIsDisplayedTest()throws InterruptedException {
        loginPage.verifyLoginpageIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyLoginpageIsDisplayedTest")
    public void enterEmailTest() throws InterruptedException{
        loginPage.enterEmail("zee2025@ndosi.com");
    }

    @Test(dependsOnMethods = "enterEmailTest")
    public void enterPasswordTest() throws InterruptedException{
        loginPage.enterPassword("Zee@2025");
    }

    @Test(dependsOnMethods = "enterPasswordTest")
    public void loginButtonSubmitTest() throws InterruptedException{
        loginPage.loginButtonSubmit();
    }

    //LearningMaterialPage
    @Test(dependsOnMethods = "loginButtonSubmitTest")
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
//    @Test(dependsOnMethods = "clickApplyDiscountButtonTest")
//    public void verifyPreviewPageIsDisplayedTest() throws InterruptedException{
//        webAutomationAdvanceTab.verifyPreviewPageIsDisplayed();
//    }
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
    public void selectWarrantyOptionsDeviceTwoTest()throws InterruptedException {
        webAutomationAdvanceTab.selectWarrantyOptions("1yr");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    @Test(dependsOnMethods = "selectShippingOptionsDeviceTwoTest")
    public void clickAddToCartButtonDeviceTwoTest()throws InterruptedException {
        webAutomationAdvanceTab.clickAddToCartButton();
    }

//   @AfterTest
//    public void closeBrowser() {
//        driver.quit();
//    }
}
