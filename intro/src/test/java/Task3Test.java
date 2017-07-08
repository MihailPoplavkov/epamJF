import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

class Task3Test {
    @SuppressWarnings("WeakerAccess")
    @Test
    public void testF() {
        MatcherAssert.assertThat(Task3.F(0), Is.is(-3.0));
    }
}