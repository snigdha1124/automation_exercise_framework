package utilities;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String path = System.getProperty("user.dir")
                + "/Screenshots/"
                + testName + ".png";

        try {

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File dest = new File(path);

            FileHandler.copy(src, dest);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return path;
    }
}