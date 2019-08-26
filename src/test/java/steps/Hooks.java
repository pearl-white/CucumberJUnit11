package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

//    @Before(value = "@amazon", order = 1)
    @Before
    public void setup(Scenario scenario){

        System.out.println("This is Hooks setup method");
    }

//    @Before(order = 2)
    public void setup2(){
        System.out.println("This is Hooks setup for google");
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("Hooks clean up");
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());

        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

        Driver.quitDriver();
    }




}
