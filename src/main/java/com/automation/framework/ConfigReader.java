package com.automation.framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    /**
     * Read specific key from properties
     *
     * @param key The key of the property to retrieve.
     * @return The value of the above mentioned key
     */
    public static String getProperty(String key) {
        Properties properties = new Properties();
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("frontend.properties")) {
            if (input == null) {
                return null;
            }
            properties.load(input);
            return properties.getProperty(key);
        } catch (IOException e) {
            System.err.println("Error reading 'frontend.properties': " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


/*    //Todo throw explicit exception? Spring?
    public static String getEnv(String... keys){
        return Arrays.stream(keys)
                .map(System::getenv)
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow();
    }*/
}
