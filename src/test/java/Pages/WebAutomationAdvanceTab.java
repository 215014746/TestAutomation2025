package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WebAutomationAdvanceTab {
    WebDriver driver;
 @FindBy(id = "inventory-title") WebElement inventoryHeader_id;
 @FindBy(id = "deviceType") WebElement deviceTypeDropDown_id;
 @FindBy(id = "brand") WebElement brand_id;
 @FindBy(id = "storage-128GB") WebElement storage_id;
 @FindBy(id = "color") WebElement colour_id;
 @FindBy(id = "quantity") WebElement quantity_id;
 @FindBy(id = "address") WebElement address_id;
 @FindBy(id = "shipping-express") WebElement shippingoption_id;
 @FindBy(id = "warranty-2yr") WebElement warranty2yr_id;
 @FindBy(id = "discount-code") WebElement discountcode_id;
 @FindBy(id = "apply-discount-btn") WebElement applydiscountbtn_id;
 @FindBy(id = "add-to-cart-btn") WebElement addtocartbtn_id;
 @FindBy(id = "purchase-device-btn") WebElement purchasedevicebtn_id;
 @FindBy(id = "inventory-next-btn") WebElement nextbtn_id;


    public WebAutomationAdvanceTab(WebDriver driver){
        this.driver=driver;
    }

    public void verifyInventoryHeaderIsDisplayed(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(inventoryHeader_id));
        inventoryHeader_id.isDisplayed();
    }
    public void selectDeviceType(String deviceType){
        deviceTypeDropDown_id.sendKeys(deviceType);
    }
    public void selectBrand(String brand){
        brand_id.sendKeys(brand);
    }
    public void selectStorage(String storage){
        storage_id.click();
    }
    public void enterColor(String colour) {
        colour_id.sendKeys(colour);
    }
    public void enterQuantity(String quantity){
        quantity_id.sendKeys(quantity);
    }
    public void enterAddress(String address){
       new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(address_id));
        address_id.sendKeys(address);
    }
    public void clickNextButton(){
        nextbtn_id.click();
    }
    public void selectShippingOption(String shipping){
        shippingoption_id.click();
    }
    public void selectWarrantyOptions(String warranty2yr) {
        warranty2yr_id.sendKeys(warranty2yr);
    }
    public void enterDiscountCode(String discountCode){
        discountcode_id.sendKeys(discountCode);
    }
    public void clickApplyDiscountButton() {
        applydiscountbtn_id.click();
    }
//    public void clickAddToCartButton(){
//        addtocartbtn_id.click();
//    }
    public void clickPurchaseButton(){
        purchasedevicebtn_id.click();
    }

}
