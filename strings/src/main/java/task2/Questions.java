package task2;

import lombok.SneakyThrows;

import java.util.Locale;
import java.util.ResourceBundle;

@SuppressWarnings("WeakerAccess")
public class Questions {
    private ResourceBundle resourceBundle;

    public Questions(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("Questions", locale);
    }

    public String getQuestion(int num) {
        return getValue(String.format("q%d", num));
    }

    public String getAnswer(int num) {
        return getValue(String.format("a%d", num));
    }

    @SneakyThrows
    private String getValue(String key) {
        String latin = resourceBundle.getString(key);
        byte[] bytes = new String(latin.getBytes(), "UTF-8").getBytes("ISO-8859-1");
        return new String(bytes);
    }
}
