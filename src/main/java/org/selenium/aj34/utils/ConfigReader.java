package org.selenium.aj34.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    public static String readKey(String key){

        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream("src/test/resources/testData/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return prop.getProperty(key);
    }
}
