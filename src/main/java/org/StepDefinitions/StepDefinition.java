package org.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.BrokenLinkChecker.SeoSectionChecker;
import org.openqa.selenium.WebDriver;

public class StepDefinition extends SeoSectionChecker {
    SetUpWebDriver WebDriver  = new SetUpWebDriver();
    WebDriver driver;

    @Given("Set chrome WebDriver")
    public void setChromeWebDriver() {
        this.driver = WebDriver.getWebDriver();
    }

    @Given("Launch url at {string}")
    public void launchUrlAt(String url) {
        driver.get(url);
    }

    @When("user clicks on seo sections it should not return {int}")
    public void userClicksOnSeoSectionsItShouldNotReturn(int arg0) {
        LinkChecker(driver);
    }

    @After
    public void windowcloser(){
        driver.quit();
    }

}
