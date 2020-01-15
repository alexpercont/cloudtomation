package com.epam.workshops.cloudtomation.pom;

public interface IRegexValidatorForm {

  boolean isDisplayed();

  boolean isRegexFieldDisplayed();

  boolean isTextFieldDisplayed();

  void setText(String string);

  void setRegex(String regex);

  void validate();
}
