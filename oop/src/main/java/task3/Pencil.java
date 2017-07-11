package task3;

public abstract class Pencil implements Chancery {
    private String name;
    private double price;

    @SuppressWarnings("WeakerAccess")
    protected Pencil(String name, double price) {
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
