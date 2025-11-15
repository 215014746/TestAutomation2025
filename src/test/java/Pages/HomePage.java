package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
   WebDriver driver;

   @FindBy(id = "overview-hero")
    WebElement homepageTitle_id;
   @FindBy(id = "nav-btn-practice") WebElement learningMaterialTab_id;

   public HomePage(WebDriver driver){
       this.driver = driver;
   }

   public void verifyHomePageIsDisplayed()throws InterruptedException{
               homepageTitle_id.isDisplayed();
       Thread.sleep(2000);
   }

   public void clickLearningMaterial()throws InterruptedException{
       learningMaterialTab_id.click();
       Thread.sleep(2000);
   }
}
