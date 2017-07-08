package task2;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("WeakerAccess")
@Getter
@Setter
public abstract class Stationary {
    private double price;

    public Stationary(double price) {
        this.price = price;
    }
}
