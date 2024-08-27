package com.magento.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader(String configFilePath) {
        try {
            // Create a FileInputStream to read the config.properties file
            FileInputStream fileInputStream = new FileInputStream(configFilePath);

            // Initialize the Properties object
            properties = new Properties();

            // Load the properties file
            properties.load(fileInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get a specific property value
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
