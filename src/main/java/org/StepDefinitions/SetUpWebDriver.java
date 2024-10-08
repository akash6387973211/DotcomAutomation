package org.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetUpWebDriver {
WebDriver webDriver;

private void SetWebDriver(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    webDriver = new ChromeDriver(options);
}

    protected WebDriver getWebDriver() {
        SetWebDriver();
        return webDriver;
    }
}
