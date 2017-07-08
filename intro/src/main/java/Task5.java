/*
Получить матрицу
    1 0 0 1
    0 1 1 0
    0 1 1 0
    1 0 0 1
 */

@SuppressWarnings("WeakerAccess")
public class Task5 {
    public int[][] buildMatrix(int dim) {
        int[][] matrix = new int[dim][dim];
        int i = 0;
        int j = dim - 1;
        for (int k = 0; k < dim; k++) {
            matrix[k][i++] = 1;
            matrix[k][j--] = 1;
        }
        return matrix;
    }
}
