package task2;

@SuppressWarnings("WeakerAccess")
public class Pen extends Stationary {
    public Pen(double price) {
        super(price);
    }

    public Pen() {
        this(200);
    }

    @Override
    public String toString() {
        return String.format("Pen{price=%3.2f}", getPrice());
    }
}
