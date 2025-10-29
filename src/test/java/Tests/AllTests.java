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

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
