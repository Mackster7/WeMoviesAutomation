package Runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.DeviceRotation;

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
    public static AppiumDriver driver;

    @BeforeSuite
    public static void setup() {
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
