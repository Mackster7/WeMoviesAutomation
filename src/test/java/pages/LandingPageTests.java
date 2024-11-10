package pages;

import helper.CommonHelpers;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import javax.xml.xpath.XPath;

import java.util.List;

import static Runner.RunnerTest.driver;

public class LandingPageTests {

    private static String weMovieHomeNavTabBtnXpath = "//android.widget.ImageView[@content-desc=\"We Movies\n" + "Tab 1 of 3\"]";
    private static WebElement weMovieHomeNavTabBtn = driver.findElement(By.xpath(weMovieHomeNavTabBtnXpath));

    private static String movieExploreNavTabBtnXpath = "//android.widget.ImageView[@content-desc=\"Explore\n" + "Tab 2 of 3\"]";
    private static WebElement movieExploreNavTabBtn = driver.findElement(By.xpath(movieExploreNavTabBtnXpath));

    private static String upCommingMoviesNavTabBtnXpath = "//android.widget.ImageView[@content-desc=\"Explore\n" + "Tab 2 of 3\"]";
    private static WebElement upCommingMoviesNavTabBtn = driver.findElement(By.xpath(upCommingMoviesNavTabBtnXpath));

    private static String movieInSearchResultXpath = "//android.view.View[@content-desc=\"123\n" +
            "Parasite\n" +
            "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.\n" +
            "18.2K\n" +
            " Votes\n" +
            "8.51\"]";
    private static WebElement movieInSearchResult = driver.findElement(By.xpath(movieInSearchResultXpath));

    public static void verifyNavigationBarInAppHomeScreen() {
        CommonHelpers.waitForVisibility(weMovieHomeNavTabBtn, CommonHelpers.LARGE_WAIT);
        weMovieHomeNavTabBtn.isDisplayed();
        movieExploreNavTabBtn.isDisplayed();
        upCommingMoviesNavTabBtn.isDisplayed();
    }

    public static void verifySearchOptionInAppHomeScreen() {
        String searchBtnXpath = "//android.widget.ScrollView/android.widget.ImageView";
        WebElement searchField = driver.findElement(By.xpath(searchBtnXpath));
        CommonHelpers.waitForVisibility(searchField, CommonHelpers.LARGE_WAIT);
        if (searchField.isDisplayed()) {
            searchField.click();
        } else {
            Assert.fail("Search button is not displayed.");
        }
    }

    public static void searchMovieInSearchBox(String movieName) {
        String searchBtnXpath = "//android.widget.ScrollView/android.widget.ImageView";
        WebElement searchField = driver.findElement(By.xpath(searchBtnXpath));
        searchField.sendKeys(movieName);
    }

    public static void movieNameAppearedInSearchResults() {
        CommonHelpers.waitForVisibility(movieInSearchResult, CommonHelpers.LARGE_WAIT);
        if (!movieInSearchResult.isDisplayed()) {
            Assert.fail("Valid movie not appeared in the search result.");
        }
    }

    public static void errorMessageForInvalidMovieNameSearch() {
        String inValidMovieNameErrorXpath = "(//android.view.View[@content-desc=\"No results found.\"])[2]";
        WebElement inValidMovieNameError = driver.findElement(By.xpath(inValidMovieNameErrorXpath));
        CommonHelpers.waitForVisibility(inValidMovieNameError, CommonHelpers.LARGE_WAIT);
        if (!inValidMovieNameError.isDisplayed()) {
            Assert.fail("Error message for invalid movies name not found");
        }
    }

}