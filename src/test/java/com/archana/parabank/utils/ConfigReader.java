package src.test.java.com.archana.parabank.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties();

    static {
        String filePath = "src/test/java/config.properties";

        try (FileInputStream fis = new FileInputStream(filePath)) {
            prop.load(fis);
            System.out.println("Config file loaded successfully.");

        } catch (IOException e) {
            throw new RuntimeException(
                "Unable to load config.properties. Check file path: "
                + filePath, e);
            
        }
    }
        public static void main(String[] args) {

            System.out.println("URL: " + getProperty("url"));
            System.out.println("Browser: " + getProperty("browser"));
            System.out.println("Environment: " + getProperty("environment"));
            System.out.println("Policy Number: " + getProperty("policyNumber"));

        }
    

    public static String getProperty(String key) {
        String value = prop.getProperty(key);

        if (value == null) {
            throw new RuntimeException(
                "Property not found in config.properties: " + key);
        }

        return value;
        
    }
}