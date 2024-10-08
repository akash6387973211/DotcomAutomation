package org.BrokenLinkChecker;

import org.openqa.selenium.WebDriver;

public class StaticLinkChecker {

public static void StaticLink(String url){
    try {
        int resps = SeoSectionChecker.getResponseCode(url);
        if (resps != 200) {
            System.out.println("link is broken" + " " + url + resps);
        }

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
}
