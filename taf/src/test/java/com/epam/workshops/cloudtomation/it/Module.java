package com.epam.workshops.cloudtomation.it;

import com.epam.workshops.cloudtomation.pom.IRegexValidatorForm;
import com.epam.workshops.cloudtomation.pom.RegexValidatorFormPage;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;

public class Module extends AbstractModule {

  @Override
  protected void configure() {
    bind(Configuration.class).in(Singleton.class);
    bind(WebDriver.class).toProvider(DriverFactory.class);
    bind(IRegexValidatorForm.class).to(RegexValidatorFormPage.class);
  }
}
