import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SuppressWarnings("WeakerAccess")
public class PropertiesReader {
    private Map<String, String> map = new HashMap<>();

    public String getValue(String key) {
        return map.get(key);
    }

    public String getValue(String fileName, String key, boolean rewrite) {
        String value;
        if (!rewrite && (value = getValue(key)) != null) {
            return value;
        }
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(fileName)) {
            properties.load(inputStream);
            value = properties.getProperty(key);
            map.put(key, value);
            return value;
        } catch (FileNotFoundException fnfe) {
            System.err.println("File not found");
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public String getValue(String fileName, String key) {
        return getValue(fileName, key, false);
    }
}
