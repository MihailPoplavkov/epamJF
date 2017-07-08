package task3;

public class SoftPencil extends Pencil {
    private static int counter = 1;
    public SoftPencil() {
        super(String.format("SoftPencil%d", counter++), 270);
    }
}
