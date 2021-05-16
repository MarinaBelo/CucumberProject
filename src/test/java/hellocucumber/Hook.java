package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Constants;
import utils.DriverProvider;

import java.time.Duration;


public class Hook {
    @Before
    public void beforeMethod(Scenario scenario){
        DriverProvider.INSTANCE.getDriver().get(Constants.BASIC_URL);
        DriverProvider.INSTANCE.getDriver().manage().window().maximize();
        DriverProvider.INSTANCE.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @After
    public void afterMethod(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) DriverProvider.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Page screenshot");
        }
        DriverProvider.INSTANCE.removeDriver();
    }
}
