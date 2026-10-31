package com.archana.parabank.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties props = new Properties();

    static {
        try (InputStream is = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            props.load(is);
        } catch (Exception e) {
            throw new RuntimeException("config.properties load nahi hui", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}