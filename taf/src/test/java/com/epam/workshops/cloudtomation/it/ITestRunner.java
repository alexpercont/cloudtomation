package com.epam.workshops.cloudtomation.it;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "com.epam.workshops.cloudtomation.steps",
  features = "classpath:/features")
public class ITestRunner {

}
