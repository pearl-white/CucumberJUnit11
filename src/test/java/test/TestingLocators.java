package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class TestingLocators {
    WebDriver driver;
    BasicActions basicActions = new BasicActions();

    By parentLocator = By.cssSelector("div.dealTile");
    By childLocator = By.cssSelector("span.dotdBadge");

    @Test
    public void testLocators() {
        driver = Driver.getDriver();
        driver.get("https://www.amazon.com");
        driver.findElement(By.linkText("Today's Deals")).click();

        String elementText = "DEAL OF THE DAY";

        basicActions.getParentElement(parentLocator,childLocator,elementText).click();
    }


}
