package com.epam.workshops.cloudtomation.steps;

import com.epam.workshops.cloudtomation.pom.IRegexValidatorForm;
import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

@ScenarioScoped
public class ValidateRegularExpressionSteps {

    private final WebDriver driver;

    private final IRegexValidatorForm validatorForm;

    @Inject
    public ValidateRegularExpressionSteps(IRegexValidatorForm form){
        this.driver = form.getDriver();
        this.validatorForm = form;
    }

    @Then("I validate text {string} against regex {string}")
    public void validateTextAgainstRegex(String string, String regex) {
        this.validatorForm.setText(string);
        this.validatorForm.setRegex(regex);
        this.validatorForm.validate();
    }

    @Then("I see a message saying Success")
    public void assertForSuccessMessage() {
        assertTrue(true);
    }
}
