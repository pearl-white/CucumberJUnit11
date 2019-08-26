package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class BasicActions {

    WebDriver driver = Driver.getDriver();

    public WebElement getParentElement(By parentLocator, By childLocator, String text) {
        List<WebElement> productList = driver.findElements(parentLocator);
        for (WebElement elem : productList
        ) {
            if (elem.findElement(childLocator).getText().equals(text))
                return elem;
        }
        return null;
    }



}
