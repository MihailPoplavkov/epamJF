import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

class Task4Test {
    @SuppressWarnings("WeakerAccess")
    @Test
    public void testMax() {
        Task4 task = new Task4();
        MatcherAssert.assertThat(task.max(0, 1, 2, 3, 4, 5, 6, 7), Is.is(7.0));
        MatcherAssert.assertThat(task.max(0, 1, 2, 4, 4, 5, 6, 7), Is.is(8.0));
        MatcherAssert.assertThat(task.max(0, -1, -2, -3, -4, -5, -6, 0), Is.is(0.0));
    }
}