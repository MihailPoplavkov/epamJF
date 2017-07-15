package task3;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class FinderTest {
    private static Finder finder;
    private int risCount = 0;
    private int risunCount = 0;

    @SneakyThrows
    @BeforeAll
    static void init() {
        finder = new Finder("src/main/resources/html_dop.html");
    }

    @Test
    void testImg() {
        List<String> imgs = finder.getImgs();
        assertEquals(21, imgs.size());
        imgs.forEach(System.out::println);
    }

    @Test
    void testRefs() {
        List<String> refs = finder.getReferences();
        refs.forEach((s) -> {
            Pattern pattern1 = Pattern.compile("[Рр]ис\\.");
            Matcher matcher1 = pattern1.matcher(s);
            while (matcher1.find()) {
                risCount++;
            }

            Pattern pattern2 = Pattern.compile("[Рр]исун");
            Matcher matcher2 = pattern2.matcher(s);
            while (matcher2.find()) {
                risunCount++;
            }
            System.out.println(s);
        });

        //было подсчитано в браузере
        assertEquals(156, risCount);
        assertEquals(41, risunCount);
    }

}