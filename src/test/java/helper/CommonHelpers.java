package helper;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CommonHelpers {
    public static AppiumDriver driver;

    public static final Duration SMALL_WAIT = Duration.ofSeconds(5);
    public static final Duration MEDIUM_WAIT = Duration.ofSeconds(15); // Converted 15 seconds
    public static final Duration LARGE_WAIT = Duration.ofSeconds(30);

    public static void waitForVisibility(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
