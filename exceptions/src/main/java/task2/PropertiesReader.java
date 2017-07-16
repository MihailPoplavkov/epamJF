package task2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SuppressWarnings("WeakerAccess")
public class PropertiesReader {
    public static String getValue(String fileName, String key) {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(fileName)) {
            properties.load(inputStream);
            return properties.getProperty(key);
        } catch (FileNotFoundException fnfe) {
            System.err.println("File not found");
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
