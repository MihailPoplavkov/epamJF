import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

class PropertiesReaderTest {
    @Test
    void simpleGetValue() {
        PropertiesReader reader = new PropertiesReader();
        MatcherAssert.assertThat("ogo", Is.is(reader.getValue("src/test/resources/test.properties", "value")));
        MatcherAssert.assertThat("ogo", Is.is(reader.getValue("value")));
    }

    @Test
    void rewrite() {
        PropertiesReader reader = new PropertiesReader();
        MatcherAssert.assertThat("ogo", Is.is(reader.getValue("src/test/resources/test.properties", "value")));
        MatcherAssert.assertThat("OGOGO", Is.is(reader.getValue("src/test/resources/test2.properties", "value", true)));
        MatcherAssert.assertThat("OGOGO", Is.is(reader.getValue("value")));
    }
}