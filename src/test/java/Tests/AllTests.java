package Tests;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
@Test
public class AllTests extends Base {


    public void verifyHomePageIsDisplayedTest() {
        homePage.verifyHomePageIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyHomePageIsDisplayedTest")
    public void clickLearningMaterialTest() {
        homePage.clickLearningMaterial();
    }

    @Test(dependsOnMethods = "clickLearningMaterialTest")
    public void verifyLoginpageIsDisplayedTest() {
        loginPage.verifyLoginpageIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyLoginpageIsDisplayedTest")
    public void enterEmailTest() {
        loginPage.enterEmail("zee2025@ndosi.com");
    }

    @Test(dependsOnMethods = "enterEmailTest")
    public void enterPasswordTest() {
        loginPage.enterPassword("Zee@2025");
    }

    @Test(dependsOnMethods = "enterPasswordTest")
    public void loginButtonSubmitTest() {
        loginPage.loginButtonSubmit();
    }

    @Test(dependsOnMethods = "loginButtonSubmitTest")
   public void verifyLearningMaterialPageIsDisplayedTest() {
        learningMaterialPage.verifyLearningMaterialPageIsDisplayed();
    }
    @Test(dependsOnMethods = "verifyLearningMaterialPageIsDisplayedTest")
   public void clickWebAutomationFormTest() {
       learningMaterialPage.clickWebAutomationAdvanceTab();
    }
    @Test(dependsOnMethods = "clickWebAutomationFormTest")
    public void verifyInventoryHeaderIsDisplayedTest() {
        webAutomationAdvanceTab.verifyInventoryHeaderIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyInventoryHeaderIsDisplayedTest")
    public void selectDeviceTypeTest() {
        webAutomationAdvanceTab.selectDeviceType("Phone");
    }
    @Test(dependsOnMethods = "selectDeviceTypeTest")
    public void selectBrandTest() {
        webAutomationAdvanceTab.selectBrand("Apple");
    }
    @Test(dependsOnMethods = "selectBrandTest")
    public void selectStorageTest() {
        webAutomationAdvanceTab.selectStorage("128GB");
    }
    @Test(dependsOnMethods = "selectStorageTest")
    public void enterColorTest() {
        webAutomationAdvanceTab.enterColor("black");
    }
    @Test(dependsOnMethods = "enterColorTest")
    public void enterQuantityTest()  {
        webAutomationAdvanceTab.enterQuantity("1");
    }
    @Test(dependsOnMethods = "enterQuantityTest")
    public void enterAddressTest() {
        webAutomationAdvanceTab.enterAddress("123 Main St, Cityville");
    }
    @Test(dependsOnMethods = "enterAddressTest")
    public void clickNextbuttonTest() {
        webAutomationAdvanceTab.clickNextButton();
    }
    @Test(dependsOnMethods = "clickNextbuttonTest")
    public void selectShippingOptionsTest() {
        webAutomationAdvanceTab.selectShippingOption("express");
    }
    @Test(dependsOnMethods = "selectShippingOptionsTest")
    public void selectWarrantyOptionsTest() {
        webAutomationAdvanceTab.selectWarrantyOptions("2 Year (+R89)");
    }
    @Test(dependsOnMethods = "selectWarrantyOptionsTest")
    public void enterDiscountCodeTest() {
        webAutomationAdvanceTab.enterDiscountCode("DISCOUNT10");
    }
    @Test(dependsOnMethods = "enterDiscountCodeTest")
    public void clickApplyDiscountButtonTest() {
        webAutomationAdvanceTab.clickApplyDiscountButton();
    }
//    @Test(dependsOnMethods = "clickApplyDiscountButtonTest")
//    public void clickAddToCartButtonTest() {
//        webAutomationAdvanceTab.clickAddToCartButton();
//    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
