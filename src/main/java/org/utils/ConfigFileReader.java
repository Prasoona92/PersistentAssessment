package org.utils;

import io.cucumber.core.logging.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigFileReader {

    private static final Properties properties = new Properties();
    private static final String CONFIG_PATH = System.getProperty("user.dir") + "/src/main/config.properties";

    static {
        loadProperties();
    }

    /**
     * Loads the configuration properties from the config file.
     */
    private static void loadProperties() {
        try (FileInputStream fileInputStream = new FileInputStream(CONFIG_PATH)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Error loading config.properties from: " + CONFIG_PATH, e);
        }
    }

    /**
     * Retrieves the property value for the given key.
     *
     * @param key The property key.
     * @return The property value or null if the key is not found.
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("Property not found in config.properties");
        } else {
            System.out.println("Retrieved property :"+value);
        }
        return value;
    }
}
