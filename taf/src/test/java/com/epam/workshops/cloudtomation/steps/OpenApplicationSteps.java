package com.epam.workshops.cloudtomation.steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.epam.workshops.cloudtomation.pom.IRegexValidatorForm;
import com.google.inject.Inject;
import io.cucumber.java.After;
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
    driver.get("https://cloudtomation.appspot.com");
  }

  @Then("I see the required fields of the regex validator.")
  public void verifyRequiredFields() {
    assertFalse(validatorForm.isDisplayed());
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
