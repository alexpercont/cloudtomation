package mx.com.percont.cloudtomation.it;

import com.google.inject.AbstractModule;
import com.google.inject.Scope;
import com.google.inject.Singleton;
import mx.com.percont.cloudtomation.pom.IRegexValidatorForm;
import mx.com.percont.cloudtomation.pom.RegexValidatorFormPage;
import org.openqa.selenium.WebDriver;

public class Module extends AbstractModule {

  @Override
  protected void configure() {
    bind(IRegexValidatorForm.class).to(RegexValidatorFormPage.class);
    bind(WebDriver.class).toProvider(DriverFactory.class).in(Singleton.class);
  }
}
