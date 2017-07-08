package task3;

public class HardPencil extends Pencil {
    private static int counter = 1;
    public HardPencil() {
        super(String.format("HardPencil%d", counter++), 250);
    }
}
