import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

class Task2Test {

    @SuppressWarnings("WeakerAccess")
    @Test
    public void testSame() {
        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        Task2 task = new Task2();
        double epsilon = 0.001;
        OutputStream sysout = System.out;
        System.setOut(new PrintStream(baos1));
        task.recursive(epsilon);
        System.setOut(new PrintStream(baos2));
        task.iterative(epsilon);
        System.setOut(new PrintStream(sysout));
        MatcherAssert.assertThat(baos1.toString(), Is.is(baos2.toString()));
    }

}