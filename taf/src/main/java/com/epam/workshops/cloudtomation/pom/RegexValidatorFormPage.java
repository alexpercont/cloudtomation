package com.epam.workshops.cloudtomation.pom;

import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@ScenarioScoped
public class RegexValidatorFormPage implements IRegexValidatorForm {

  private final WebDriver driver;

  @Inject
  public RegexValidatorFormPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "regex_validation_form:regex_field")
  private WebElement regexField;

  @FindBy(id = "regex_validation_form:text_field")
  private WebElement textField;

  @FindBy(id = "regex_validation_form:submit")
  private WebElement submitButton;

  @Override
  public boolean isDisplayed() {
    return regexField.isDisplayed();
  }

  @Override
  public boolean isRegexFieldDisplayed() {
    return regexField.isDisplayed();
  }

  @Override
  public boolean isTextFieldDisplayed() {
    return textField.isDisplayed();
  }

  @Override
  public void setText(String string) {
    this.textField.sendKeys(string);
  }

  @Override
  public void setRegex(String regex) {
    this.regexField.sendKeys(regex);
  }

  @Override
  public void validate() {
    this.submitButton.click();
  }

  @Override
  public WebDriver getDriver() {
    return this.driver;
  }
}
