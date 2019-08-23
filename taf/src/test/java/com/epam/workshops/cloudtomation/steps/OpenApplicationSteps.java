package com.epam.workshops.cloudtomation.steps;

import static org.junit.Assert.assertTrue;

import com.epam.workshops.cloudtomation.pom.IRegexValidatorForm;
import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class OpenApplicationSteps {

  private final WebDriver driver;

  private final IRegexValidatorForm validatorForm;

  @Inject
  private OpenApplicationSteps(WebDriver driver, IRegexValidatorForm regexValidatorForm){
    this.driver = driver;
    this.validatorForm = regexValidatorForm;
  }

  @When("I open the Cloudtomation application")
  public void openApplication() {
    driver.get("http://host.docker.internal:8080");
  }

  @Then("I see the required fields of the regex validator.")
  public void verifyRequiredFields() {
    assertTrue(validatorForm.isDisplayed());
    assertTrue(validatorForm.isRegexFieldDisplayed());
    assertTrue(validatorForm.isTextFieldDisplayed());
  }
}