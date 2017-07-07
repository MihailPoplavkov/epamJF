/*
Найти наименьший номер элемента последовательности, для которого выполняется условие M.
Вывести на экран этот номер и все элементы ai  где i = 1, 2, ..., п.
an = 1/(n+1)^2, M: an < eps
 */

@SuppressWarnings("WeakerAccess")
public class Task2 {
    public void recursive(double epsilon) {
        recursive(epsilon, 1);
    }

    private void recursive(double epsilon, int i) {
        double a = calculate(i);
        if (a >= epsilon) {
            recursive(epsilon, i + 1);
        } else {
            System.out.println(i);
        }
        System.out.printf("%3d: %3.6f\n", i, a);
    }

    public void iterative(double epsilon) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (true) {
            double a = calculate(i);
            sb.insert(0, String.format("%3d: %3.6f\n", i, a));
            if (a < epsilon) {
                sb.insert(0, String.format("%d\n", i));
                break;
            }
            i++;
        }
        System.out.print(sb);
    }

    private double calculate(int i) {
        return 1 / Math.pow(i, 2);
    }
}
