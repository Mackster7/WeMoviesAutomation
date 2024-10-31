package Runner;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import java.net.URL;
import java.net.MalformedURLException;

@CucumberOptions(
        features = {
            "src/test/java/features/LandingPage.feature"
        },
        glue = "stepdef",
        tags = "@Sanity",
        plugin = {
                "pretty", "html:target/cucumber/report.html", "summary"
        },
        monochrome = true
)

public class RunnerTest extends AbstractTestNGCucumberTests {
    static AppiumDriver driver;

    @BeforeSuite
    public static void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Simulator");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "14");
        cap.setCapability("automationName", "uiAutomator2");
        cap.setCapability("appPackage", "com.example.wework");
        cap.setCapability("appActivity", "com.example.wework.MainActivity");
        cap.setCapability("autoGrantPermissions", true);
        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url, cap);
        System.out.println("Appium Started");
    }

    @AfterSuite
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Appium Stopped");
        }
    }
}
