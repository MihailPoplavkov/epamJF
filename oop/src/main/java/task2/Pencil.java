package task2;

@SuppressWarnings("WeakerAccess")
public class Pencil extends Stationary {
    public Pencil(double price) {
        super(price);
    }

    public Pencil() {
        this(100);
    }

    @Override
    public String toString() {
        return String.format("Pencil{price=%3.2f}", getPrice());
    }
}
