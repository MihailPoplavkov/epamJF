package task7;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import task6.NuclearPoweredBoat;

class AnnotationTest {
    @Test
    void test() {
        MatcherAssert.assertThat("NuclearPoweredBoat", Is.is(NuclearPoweredBoat.getValueFromAnnotation()));
    }
}
