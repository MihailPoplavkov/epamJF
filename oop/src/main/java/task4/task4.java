package task4;

import task3.Chancery;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("WeakerAccess")
public class task4 {
    public void sortByPrice(Chancery[] items) {
        Arrays.sort(items, Comparator.comparingDouble(Chancery::getPrice));
    }

    public void sortByName(Chancery[] items) {
        Arrays.sort(items, Comparator.comparing(Chancery::getName));
    }

    public void sortByPriceAndName(Chancery[] items) {
        Arrays.sort(items, (a, b) ->
                Double.compare(a.getPrice(), b.getPrice()) == 0
                        ? a.getName().compareTo(b.getName())
                        : Double.compare(a.getPrice(), b.getPrice()));
    }
}
