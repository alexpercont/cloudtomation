package com.epam.workshops.cloudtomation.it;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory implements Provider<WebDriver> {

  private final Configuration config;

  @Inject
  public DriverFactory(Configuration config){
    this.config = config;
  }

  @Override
  public WebDriver get() {
    ChromeOptions capabilities = new ChromeOptions();
    WebDriver driver = null;
    try {
      driver = new RemoteWebDriver(getWebDriverUrl(), capabilities);
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException("bad url", e);
    }
    return driver;
  }

  private URL getWebDriverUrl() throws MalformedURLException {
    String webDriverUrl = this.config.getProperty("webdriver.url");
    return new URL(webDriverUrl);
  }
}
