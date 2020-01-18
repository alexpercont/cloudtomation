package com.epam.workshops.cloudtomation.it;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class Configuration {

    private static final String TEST_PROPERTIES = "/test.properties";
    private static final String WEBDRIVER_URL = "webdriver.url";
    private Properties properties;

    public Configuration() throws IOException {
        loadPropertiesFile();
        loadSystemProperties();
    }

    private void loadPropertiesFile() throws IOException {
        InputStream istream = getClass().getResourceAsStream(TEST_PROPERTIES);
        properties = new Properties();
        properties.load(istream);
    }

    private void loadSystemProperties(){
        Set<String> names = properties.stringPropertyNames();
        names.parallelStream().forEach((name) -> {
            String systemProperty = System.getProperty(name, null);
            if (null != systemProperty) {
                properties.setProperty(name, systemProperty);
            }
        });
    }

    public String getProperty(String key){
        return this.properties.getProperty(key, null);
    }

    public String getWebDriverUrl(){
        return getProperty(WEBDRIVER_URL);
    }
}
