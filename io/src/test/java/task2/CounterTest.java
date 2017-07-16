package task2;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {
    @SneakyThrows
    @Test
    void testCount() {
        Counter counter = new Counter("src/main/java/task2/Counter.java", "src/test/resources/output.txt");
        counter.count();
        Map<String, Integer> map = new HashMap<>();
        map.put("package", 1);
        map.put("import", 3);
        map.put("public", 4);
        map.put("private", 3);
        map.put("class", 1);
        map.put("static", 2);
        map.put("new", 8);
        map.put("throws", 2);
        map.put("this", 1);
        map.put("void", 1);
        map.put("int", 1);
        map.put("while", 1);
        map.put("if", 5);
        map.put("else", 3);
        map.put("char", 1);
        map.put("for", 1);

        Map<String, Integer> resultMap = new HashMap<>();
        InputStream inputStream = new FileInputStream("src/test/resources/output.txt");
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        String key = null;
        int value;
        while ((i = inputStream.read()) > 0) {
            if (i == ' ') {
                key = stringBuilder.toString();
                stringBuilder = new StringBuilder();
            } else if (i == '\n') {
                value = new Integer(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                resultMap.put(key, value);
            } else {
                stringBuilder.append((char)i);
            }
        }
        inputStream.close();

        assertEquals(map, resultMap);
    }
}