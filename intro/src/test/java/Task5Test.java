import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    @SuppressWarnings("WeakerAccess")
    @Test
    public void buildMatrix() {
        Task5 task = new Task5();
        int[][] correct4 = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };
        assertArrayEquals(task.buildMatrix(4), correct4);
        int[][] correct5 = {
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}
        };
        assertArrayEquals(task.buildMatrix(5), correct5);
    }
}