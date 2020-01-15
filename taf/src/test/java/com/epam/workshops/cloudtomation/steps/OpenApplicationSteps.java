package com.epam.workshops.cloudtomation.steps;

import com.epam.workshops.cloudtomation.it.Configuration;
import com.epam.workshops.cloudtomation.pom.IRegexValidatorForm;
import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

@ScenarioScoped
public class OpenApplicationSteps {

  private final WebDriver driver;

  private final IRegexValidatorForm validatorForm;

  private final Configuration config;

  @Inject
  public OpenApplicationSteps(IRegexValidatorForm regexValidatorForm, Configuration config){
    this.driver = regexValidatorForm.getDriver();
    this.validatorForm = regexValidatorForm;
    this.config = config;
  }

  @When("I open the Cloudtomation application")
  public void openApplication() {
    String appUrl = config.getProperty("sut.url");
    driver.get(appUrl);
  }

  @Then("I see the required fields of the regex validator.")
  public void verifyRequiredFields() {
    assertTrue(validatorForm.isDisplayed());
    assertTrue(validatorForm.isRegexFieldDisplayed());
    assertTrue(validatorForm.isTextFieldDisplayed());
  }

  @After
  public void stopDriver(){
    if (null != this.driver){
      this.driver.quit();
    }
  }
}
