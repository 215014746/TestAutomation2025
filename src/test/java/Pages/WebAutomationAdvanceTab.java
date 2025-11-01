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
 @FindBy(id = "storage-64GB") WebElement storage64_id;
 @FindBy(id = "storage-128GB") WebElement storage128_id;
 @FindBy(id = "storage-256GB") WebElement storage256_id;
 @FindBy(id = "color") WebElement colour_id;
 @FindBy(id = "quantity") WebElement quantity_id;
 @FindBy(id = "address") WebElement address_id;
 @FindBy(id = "shipping-option-express") WebElement shippingoptionexpress_id;
 @FindBy(id = "shipping-option-standard") WebElement shippingoptionstandard_id;
 @FindBy(id = "warranty-option-none") WebElement warrantynone_id;
 @FindBy(id = "warranty-1yr") WebElement warranty1yr_id;
 @FindBy(id = "warranty-2yr") WebElement warranty2yr_id;
 @FindBy(id = "discount-code") WebElement discountcode_id;
 @FindBy(id = "apply-discount-btn") WebElement applydiscountbtn_id;
 @FindBy(id = "add-to-cart-btn") WebElement addtocartbtn_id;
 @FindBy(id = "purchase-device-btn") WebElement purchasedevicebtn_id;
 @FindBy(id = "inventory-next-btn") WebElement nextbtn_id;
 @FindBy(id = "preview-section-title") WebElement devicepreview_id;
 @FindBy(id = "pricing-summary") WebElement pricingsummary_id;
 @FindBy(id = "discount-code") WebElement discountcodefield_id;

    public WebAutomationAdvanceTab(WebDriver driver){
        this.driver=driver;
    }

    public void verifyInventoryHeaderIsDisplayed() throws InterruptedException{
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(inventoryHeader_id));
        inventoryHeader_id.isDisplayed();
        Thread.sleep(1000);
    }
    public void selectDeviceType(String deviceType)throws InterruptedException{
        deviceTypeDropDown_id.sendKeys(deviceType);
        Thread.sleep(1000);
    }
    public void selectBrand(String brand)throws InterruptedException{
        brand_id.sendKeys(brand);
        Thread.sleep(1000);
    }
    public void selectStorage(String storage)throws InterruptedException{
        if(storage.equals("64GB")){
            storage64_id.click();
        } else if (storage.equals("128GB")) {
            storage128_id.click();
        } else if (storage.equals("256GB")) {
            storage256_id.click();
        }
        Thread.sleep(1000);
    }

    public void enterColor(String colour)throws InterruptedException {
        colour_id.sendKeys(colour);
        Thread.sleep(1000);
    }
    public void enterQuantity(String quantity)throws InterruptedException{
        quantity_id.clear();
        quantity_id.sendKeys(quantity);
        Thread.sleep(1000);
    }
    public void enterAddress(String address)throws InterruptedException{
       //new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(address_id));
        address_id.sendKeys(address);
        Thread.sleep(1000);
    }
    public void clickNextButton()throws InterruptedException{
        nextbtn_id.click();
        Thread.sleep(1000);
    }
    public void selectShippingOption(String option)throws InterruptedException{

        if (option.equalsIgnoreCase("express")) {
            shippingoptionexpress_id.click();
        } else if (option.equalsIgnoreCase("standard")) {
            shippingoptionstandard_id.click();
        } else {
            throw new IllegalArgumentException("Invalid shipping option: " + option);
        }

        Thread.sleep(1000);
    }
    public void selectWarrantyOptions(String warranty)throws InterruptedException {

        if (warranty.equalsIgnoreCase("none")) {
            warrantynone_id.click();
        } else if (warranty.equalsIgnoreCase("1yr")) {
            warranty1yr_id.click();
        } else if (warranty.equalsIgnoreCase("2yr")) {
            warranty2yr_id.click();
        } else {
            throw new IllegalArgumentException("Invalid warranty option: " + warranty);
        }

        Thread.sleep(1000);
    }
    public void enterDiscountCode(String discountCode)throws InterruptedException{
        discountcode_id.sendKeys(discountCode);
        Thread.sleep(1000);
    }
    public void clickApplyDiscountButton()throws InterruptedException {
        applydiscountbtn_id.click();
        Thread.sleep(1000);
    }
    public void verifyPreviewPageIsDisplayed()throws InterruptedException{
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(devicepreview_id));
        devicepreview_id.isDisplayed();
        Thread.sleep(1000);
    }
    public void verifyPricingSummaryIsDisplayed()throws InterruptedException{
       // new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(pricingsummary_id));
        pricingsummary_id.isDisplayed();
        Thread.sleep(1000);
    }
    public void clickAddToCartButton()throws InterruptedException{
        addtocartbtn_id.click();
        Thread.sleep(1000);
    }

    public void clickPurchaseButton()throws InterruptedException{
        purchasedevicebtn_id.click();
        Thread.sleep(1000);
    }

}
