package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    public static Properties getProp(String filePath) {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(filePath)) {
            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return prop;
    }
}
