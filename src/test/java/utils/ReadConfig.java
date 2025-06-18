package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    public static Properties loadConfig() throws Exception {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("config/config.properties");
        prop.load(fis);
        return prop;
    }
}
