package mx.com.percont.cloudtomation.it;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "mx.com.percont.cloudtomation.steps",
  features = "classpath:/features")
public class ITestRunner {

}
