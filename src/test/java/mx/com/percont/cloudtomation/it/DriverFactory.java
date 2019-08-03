package mx.com.percont.cloudtomation.it;

import com.google.inject.Provider;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory implements Provider<WebDriver> {

  @Override
  public WebDriver get() {
    ChromeOptions capabilities = new ChromeOptions();
    WebDriver driver = null;
    try {
      driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException("bad url", e);
    }
    return driver;
  }
}
