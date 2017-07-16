package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesReaderTest {
    @Test
    void testNonexistentFile() {
        assertNull(PropertiesReader.getValue("src/test/resources/nonexistent", "some"));
    }

    @Test
    void testNonexistentValue() {
        assertNull(PropertiesReader.getValue("src/test/resources/test.properties", "some"));
    }

    @Test
    void testReadValue() {
        assertEquals("ogo", PropertiesReader.getValue("src/test/resources/test.properties", "value"));
    }
}