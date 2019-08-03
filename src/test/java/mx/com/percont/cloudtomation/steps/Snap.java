package mx.com.percont.cloudtomation.steps;

import com.google.inject.Inject;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Snap {

  private final WebDriver driver;

  @Inject
  public Snap(WebDriver driver){
    this.driver = driver;
  }

  @After
  public void takesnapshot(Scenario scenario){
    if (scenario.isFailed()){
      TakesScreenshot takeScreenshotDriver = TakesScreenshot.class.cast(driver);
      File screenshotAs = takeScreenshotDriver.getScreenshotAs(OutputType.FILE);
      System.out.println(screenshotAs.getAbsolutePath());
    }
  }

}
