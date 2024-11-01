package pages;

import helper.CommonHelpers;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import javax.xml.xpath.XPath;

import static Runner.RunnerTest.driver;

public class LandingPageTests {

    private static String weMovieHomeNavTabBtnXpath = "//android.widget.ImageView[@content-desc=\"We Movies\n" + "Tab 1 of 3\"]";
    private static WebElement weMovieHomeNavTabBtn = driver.findElement(By.xpath(weMovieHomeNavTabBtnXpath));

    private static String movieExploreNavTabBtnXpath = "//android.widget.ImageView[@content-desc=\"Explore\n" + "Tab 2 of 3\"]";
    private static WebElement movieExploreNavTabBtn = driver.findElement(By.xpath(movieExploreNavTabBtnXpath));

    private static String upCommingMoviesNavTabBtnXpath = "//android.widget.ImageView[@content-desc=\"Explore\n" + "Tab 2 of 3\"]";
    private static WebElement upCommingMoviesNavTabBtn = driver.findElement(By.xpath(upCommingMoviesNavTabBtnXpath));

    public static void verifyNavigationBarInAppHomeScreen() {
        CommonHelpers.waitForVisibility(weMovieHomeNavTabBtn, CommonHelpers.LARGE_WAIT);
        weMovieHomeNavTabBtn.isDisplayed();
        movieExploreNavTabBtn.isDisplayed();
        upCommingMoviesNavTabBtn.isDisplayed();
    }

    public static void tapOnSearchMoviesSearchBox() {
        String searchBtnXpath = "//android.widget.ScrollView/android.widget.ImageView";
        WebElement searchButton = driver.findElement(By.xpath(searchBtnXpath));
        CommonHelpers.waitForVisibility(searchButton, CommonHelpers.LARGE_WAIT);
        if (searchButton.isDisplayed()) {
            searchButton.click();
        } else {
            Assert.fail("Search button is not displayed.");
        }
    }

    public static void movieNameAppearedInSearchResults() {

    }
}