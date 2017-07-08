package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    @Test
    void test() {
        Worker worker = new Worker();
        Pen pen1 = new Pen();
        Pen pen2 = new Pen();
        Pen pen3 = new Pen(150);
        Pencil pencil1 = new Pencil();
        Pencil pencil2 = new Pencil(80);
        worker.addItem(pen1);
        worker.addItem(pen2);
        worker.addItem(pen3);
        worker.addItem(pencil1);
        worker.addItem(pencil2);
        assertEquals(730.0, worker.getAllPrice());
    }
}