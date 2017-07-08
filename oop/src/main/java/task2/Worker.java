package task2;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Worker {
    private List<Stationary> list = new ArrayList<>();

    public void addItem(Stationary stationary) {
        list.add(stationary);
    }

    public double getAllPrice() {
        return list.stream()
                .mapToDouble(Stationary::getPrice)
                .sum();
    }
}
