package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrazyLoggerTest {
    @Test
    void loggerTest() {
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("Hello");
        logger.addMessage("Hello everybody");
        logger.addMessage("Helo!");
        assertEquals(2, logger.search("Hello", false));
    }

    @Test
    void testWithN() {
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("Hello\nHello\nHello\nHello\nHello\nHello\nHello\n");
        assertEquals(1, logger.search("", false));
    }
}