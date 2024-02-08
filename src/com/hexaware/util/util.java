package com.hexaware.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class util {

    private static final String PROP_FILE = "/db.properties";
    private static Properties properties = new Properties();

    static {
        try (InputStream inputStream = util.class.getResourceAsStream(PROP_FILE)) {
            if (inputStream == null) {
                throw new RuntimeException("Unable to find " + PROP_FILE);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load database properties file.", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

