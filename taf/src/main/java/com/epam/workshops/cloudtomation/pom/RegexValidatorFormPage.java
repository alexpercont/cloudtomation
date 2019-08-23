package com.epam.workshops.cloudtomation.pom;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegexValidatorFormPage implements IRegexValidatorForm {

  @Inject
  public RegexValidatorFormPage(WebDriver driver){
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "regex_validation_form:regex_field")
  private WebElement regexField;

  @FindBy(id = "regex_validation_form:text_field")
  private WebElement textField;

  @FindBy(id = "regex_validation_form.submit")
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
}
