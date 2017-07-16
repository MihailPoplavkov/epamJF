package task1;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class FileWalkerTest {
    private FileWalker walker = new FileWalker();

    @Test
    void printFileTreeTest() {
        walker.printFileTree(".");
    }

    @Test
    void createAndDeleteFileTest() {
        String fileName = "src/test/resources/abcdefgh.txt";
        File file = new File(fileName);
        assertTrue(walker.createFile(fileName));
        assertTrue(file.exists());
        assertTrue(walker.deleteFile(fileName));
        assertFalse(file.exists());
    }

    @SneakyThrows
    @Test
    void testWriteToFile() {
        String first = "Hello";
        String second = " World";
        String fileName = "src/test/resources/output.txt";
        assertTrue(walker.writeToFile(fileName, first));
        assertTrue(walker.writeToFile(fileName, second));
        FileReader fileReader = new FileReader(fileName);
        char[] chars = new char[first.length() + second.length()];
        //noinspection ResultOfMethodCallIgnored
        fileReader.read(chars);
        fileReader.close();
        walker.deleteFile(fileName);
        assertEquals(first + second, new String(chars));
    }
}