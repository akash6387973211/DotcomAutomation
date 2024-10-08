package org.BrokenLinkChecker;

import org.Locators.ListingDseLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SeoSectionChecker extends StaticLinkChecker {
    ListingDseLocators loc = new ListingDseLocators();
    By[] locatorsArray = {loc.ZonesLink,loc.LocalityLink};
    public static int getResponseCode(String urlString) {
        try{
            URL url = new URL(urlString);
            HttpURLConnection huc =  (HttpURLConnection)url.openConnection();
            huc.setRequestMethod("HEAD");
            huc.connect();
            return huc.getResponseCode();

        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public void LinkChecker(WebDriver driver){

       for(By locator :locatorsArray){
           List<WebElement> links = driver.findElements(locator);
           if (links != null){
               for (WebElement link:links){
                   String url = link.getAttribute("data-href");
                   if(url==null){
                       url = link.getAttribute("href");
                       ((JavascriptExecutor) driver).executeScript("window.open(arguments[0]);", url);
                   }else{
                       ((JavascriptExecutor) driver).executeScript("window.open(arguments[0]);", url);
                   }


                   Set<String> windowHandles = driver.getWindowHandles();
                   Iterator<String> windowIterator  = windowHandles.iterator();
                   String parent = windowIterator.next();
                   String child_window = windowIterator.next();
                   driver.switchTo().window(child_window);
                   System.out.println(driver.switchTo().window(child_window).getTitle());
                   StaticLink(driver.getCurrentUrl());
                   driver.close();
                   driver.switchTo().window(parent);
               }
           }
       }
    }


}
