package task3;

public class BigPen extends Pen {
    private static int counter = 1;
    public BigPen() {
        super(String.format("BigPen%d", counter++), 100);
    }
}
