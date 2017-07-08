/*
Даны действительные числа a1, a2 … an.  Найти max (a1 + an, a2 + an-1...)
 */

@SuppressWarnings("WeakerAccess")
public class Task4 {
    public double max(double ... values) {
        if (values.length < 1 || !(values.length % 2 == 0)) throw new IllegalArgumentException();
        int i = 0;
        int j = values.length - 1;
        double max = values[i++] + values[j--];
        double tmp;
        while (i < j) {
            tmp = values[i++] + values[j--];
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }
}
