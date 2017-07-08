package task3;

public abstract class Pen implements Chancery {
    private double price;
    private String name;

    @SuppressWarnings("WeakerAccess")
    protected Pen(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
