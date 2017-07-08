package task3;

public class LittlePen extends Pen {
    private static int counter = 1;
    public LittlePen() {
        super(String.format("LittlePen%d", counter++), 100);
    }
}
