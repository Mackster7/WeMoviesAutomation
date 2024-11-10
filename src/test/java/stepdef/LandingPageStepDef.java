package stepdef;

import helper.CommonHelpers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LandingPageTests;
import java.net.MalformedURLException;
import java.net.URL;
import static Runner.RunnerTest.driver;

public class LandingPageStepDef {
    WebDriverWait largeWait;
    WebDriverWait mediumWait;
    WebDriverWait smallWait;

    @Before
    public void beforeScenario() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Simulator");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "14");
        cap.setCapability("automationName", "uiAutomator2");
        cap.setCapability("appPackage", "com.example.wework");
        cap.setCapability("appActivity", "com.example.wework.MainActivity");
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("unicodeKeyboard", true);
        cap.setCapability("resetKeyboard", true);
        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url, cap);

        // Initialize waits
        largeWait = new WebDriverWait(driver, CommonHelpers.LARGE_WAIT);
        mediumWait = new WebDriverWait(driver, CommonHelpers.MEDIUM_WAIT);
        smallWait = new WebDriverWait(driver, CommonHelpers.SMALL_WAIT);

        // Initialize PageFactory elements
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("User launches the app")
    public void userLanchesTheApp() {
        
    }

    @When("User is in app landing page")
    public void verifyUserIsInLandingPage() {

    }

    @Then("Verify the navigation bar in app landing page")
    public void verifyNavBar() {
        LandingPageTests.verifyNavigationBarInAppHomeScreen();
    }

    @Then("Verify user is able to see the search option")
    public void verifySearchOption() {
        LandingPageTests.verifySearchOptionInAppHomeScreen();
    }

    @When("User clicks on search option and start search a movie valid name")
    public void verifyValidMovieSearch() {
        LandingPageTests.searchMovieInSearchBox("Parasite");
    }

    @Then("Verify movies is appeared in search list")
    public void verifySearchList() {
        LandingPageTests.movieNameAppearedInSearchResults();
    }

    @When("User clicks on search option and start search an invalid movie")
    public void verifyInvalidMovieSearch() {
        LandingPageTests.searchMovieInSearchBox("Life of Pie");
    }

    @Then("Verify no result found error screen")
    public void verifyErrorScreenForInvaidMovieSearch() {
        LandingPageTests.errorMessageForInvalidMovieNameSearch();
    }
}
