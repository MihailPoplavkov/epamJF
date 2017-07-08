/*
Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h.
Результат представить в виде таблицы, первый столбец которой – значения аргумента,
второй - соответствующие значения функции:
 */

@SuppressWarnings("ALL")
public class Task3 {
    public void buildTable(double a, double b, double h) {
        System.out.println("Argument\t\t\tValue");
        while (a <= b) {
            System.out.printf("%5.3f\t\t\t%+5.5f\n", a, F(a));
            a += h;
        }
    }

    public static double F(double x) {
        return Math.tan(2 * x) - 3;
    }

    public static void main(String[] args) {
        new Task3().buildTable(0, 10, 0.1);
    }
}
