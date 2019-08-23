package com.epam.workshops.cloudtomation.it;

import com.google.inject.Guice;
import cucumber.api.guice.CucumberModules;
import cucumber.runtime.java.guice.InjectorSource;

public class Injector implements InjectorSource {

  @Override
  public com.google.inject.Injector getInjector() {
    return Guice.createInjector(new Module(), CucumberModules.createScenarioModule());
  }
}
