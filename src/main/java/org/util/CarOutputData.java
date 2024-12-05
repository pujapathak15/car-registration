package org.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class CarOutputData {
    public Map<String, String> readExpectedResults(String filePath) throws IOException {
        Properties properties = new Properties();
        Map<String, String> resultMap = new HashMap<>();

        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        }

        for (String key : properties.stringPropertyNames()) {
            resultMap.put(key, properties.getProperty(key));
        }
        return resultMap;
    }


    public boolean validate(String actualResult, String expectedResult) {
        return actualResult.equalsIgnoreCase(expectedResult);
    }
}
