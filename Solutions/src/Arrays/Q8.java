package Arrays;

public class Q8 {

    public static void main(String[] args) {
        int[][] matrix = {
            { 0, 3, 3 },
            { 3, 3, 3 },
            { 3, 3, 3 },
            { 3, 3, 0 }
        };

        Q8 q8 = new Q8();
        matrix = q8.zeroMatrix(matrix);

        // Print Results
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    // Method to nullify (set to zero) a row
    public void nullifyRow(int[][] matrix, int row) {
        for (int col = 0; col < matrix[row].length; col++) {
            matrix[row][col] = 0;
        }
    }

    // Method to nullify (set to zero) a column
    public void nullifyCol(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }

    // Main method to convert matrix with zeros in rows and columns
    public int[][] zeroMatrix(int[][] matrix) {
        boolean row1_has_zero = false;
        boolean col1_has_zero = false;

        // Check if the first row has a zero
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                row1_has_zero = true;
            }
        }

        // Check if the first column has a zero
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                col1_has_zero = true;
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                nullifyRow(matrix, row);
            }
        }

        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                nullifyCol(matrix, col);
            }
        }

        if (row1_has_zero) {
            nullifyRow(matrix, 0);
        }

        if (col1_has_zero) {
            nullifyCol(matrix, 0);
        }

        return matrix;
    }
}
