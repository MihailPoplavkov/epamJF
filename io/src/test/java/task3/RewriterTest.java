package task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RewriterTest {
    @Test
    void testUse() {
        new Rewriter().rewrite("src/test/resources/utf8.txt", "src/test/resources/utf16.txt");
    }
}