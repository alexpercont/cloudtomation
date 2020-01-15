package com.epam.workshops.cloudtomation.pom;

import org.openqa.selenium.WebDriver;

public interface IRegexValidatorForm {

  boolean isDisplayed();

  boolean isRegexFieldDisplayed();

  boolean isTextFieldDisplayed();

  void setText(String string);

  void setRegex(String regex);

  void validate();

    WebDriver getDriver();
}
