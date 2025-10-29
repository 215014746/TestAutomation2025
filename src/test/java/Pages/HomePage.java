package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
   WebDriver driver;

   @FindBy(id = "overview-hero")
    WebElement homepageTitle_id;
   @FindBy(id = "nav-btn-practice") WebElement learningMaterialTab_id;

   public HomePage(WebDriver driver){
       this.driver = driver;
   }

   public void verifyHopePageIsDisplayed(){
       new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(homepageTitle_id));
               homepageTitle_id.isDisplayed();
   }

   public void clickLearningMaterial(){
       learningMaterialTab_id.click();
   }
}
