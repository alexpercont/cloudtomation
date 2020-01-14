package com.epam.workshops.cloudtomation.it;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private Properties properties;

    public Configuration() throws IOException {
        InputStream istream = getClass().getResourceAsStream("/test.properties");
        properties = new Properties();
        properties.load(istream);
    }

    public Properties getProperties(){
        return this.properties;
    }

    public String getProperty(String key){
        return this.properties.getProperty(key, null);
    }
}
