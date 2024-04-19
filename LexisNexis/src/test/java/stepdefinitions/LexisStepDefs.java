package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LexisStepDefs {

    private WebDriver driver;
    private WebDriverWait wait;


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Given("I open the LexisNexis homepage")
    public void i_open_the_lexisnexis_homepage() {
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        // Navigate to the LexisNexis homepage
        driver.get("https://risk.lexisnexis.co.uk/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-cookies");
    }

    @When("the user navigates to the {string} page and then to Careers")
    public void the_user_navigates_to_the_page_and_then_to(String menu) {
        WebElement menuElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(menu)));
        menuElement.click();
        WebElement submenuElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a.score-button.btn-clickable-area[href*='corporate/careers']")));
        submenuElement.click();
    }

    @And("the user clicks on Search all jobs")
    public void the_user_clicks_on() {

        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Increase the wait time
        WebElement submenuElement = longWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class, 'score-button') and contains(@href, 'corporate/careers/jobs') and contains(text(), 'Search all jobs')]")));
        submenuElement.click();
    }
}
//    @And("the user searches for {string} in the search box")
//    public void the_user_searches_for_in_the_search_box(String searchText) {
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.search-query")));
//        searchBox.sendKeys(searchText);
//        searchBox.submit();  // Assuming there's a form submission or search button to click
//    }
//
//    @Then("the user should see at least one search result")
//    public void the_user_should_see_at_least_one_search_result() {
//        // Assuming search results are in a list or table which can be identified
//        List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".search-result")));
//        assertTrue("No search results found.", results.size() > 0);
//    }



