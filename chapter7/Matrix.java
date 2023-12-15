import java.util.Arrays;

public  class Matrix {
    /*
    * Takes a two-dimensional array as a matrix and returns the transpose
    * of the matrix.
    * @param matrix two-dimensional array to be transposed
    * @return the transpose of the array passed as argument
     */
    public static int[][] transpose(int[][] matrix) {
        final int COLUMN = matrix.length;
        final int ROW = matrix[0].length;
        int[][] transposedMatrix = new int[ROW][COLUMN];

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        return transposedMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        System.out.println(Arrays.deepToString(transpose(matrix)));
    }
}