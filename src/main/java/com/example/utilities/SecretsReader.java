package com.example.utilities;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
@Slf4j
public class SecretsReader {

    private static Properties props = new Properties();

    public static void readProperties() {
        if (props.isEmpty()) {
            try {
                InputStream is = SecretsReader.class.getClassLoader().getResourceAsStream("credentials.properties");
                props.load(is);
            } catch (IOException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String name) {
        return props.getProperty(name);
    }
}
