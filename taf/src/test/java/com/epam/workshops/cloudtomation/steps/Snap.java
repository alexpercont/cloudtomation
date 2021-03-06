package com.epam.workshops.cloudtomation.steps;

import com.epam.workshops.cloudtomation.it.Configuration;
import com.epam.workshops.cloudtomation.pom.IRegexValidatorForm;
import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@ScenarioScoped
public class Snap {

  private final WebDriver driver;
  private final Configuration config;

  @Inject
  public Snap(IRegexValidatorForm form, Configuration c){
    this.driver = form.getDriver();
    this.config = c;
  }

  @After(order = Integer.MAX_VALUE)
  public void takesnapshot(Scenario scenario) throws IOException {
    if (scenario.isFailed()){
      TakesScreenshot takeScreenshotDriver = TakesScreenshot.class.cast(driver);
      File screenshotAs = takeScreenshotDriver.getScreenshotAs(OutputType.FILE);
      FileSystem fileSystem = FileSystems.getDefault();
      Path p = fileSystem.getPath(screenshotAs.getAbsolutePath());
      Path desktop = fileSystem.getPath(config.getSnapshotPath() + "/screenshot_"+ LocalDateTime
          .now().hashCode() + ".png");
      Files.move(p, desktop);
    }
  }

}
