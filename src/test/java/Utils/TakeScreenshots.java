package Utils;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class TakeScreenshots {

    private static final String screenshotDir = System.getProperty("user.dir") + "/Screenshots/";

    public void takesSnapshot(WebDriver driver, String screenshortName) {
      TakesScreenshot takesScreenshots = (TakesScreenshot) driver;
        File src = takesScreenshots.getScreenshotAs(OutputType.FILE);
        File destination = new File(screenshotDir + screenshortName + ".png");

        try {
             Files.copy(src, destination);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
