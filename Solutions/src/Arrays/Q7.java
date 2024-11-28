package Arrays;

public class Q7 {

    public static void main(String[] args) {
        int[][] matrix = { 
            { 1, 2, 3, 4 }, 
            { 5, 6, 7, 8 }, 
            { 9, 1, 2, 3 }, 
            { 4, 5, 6, 7 } 
        };
        Q7 q7 = new Q7();
        q7.rotate90(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void rotate90(int[][] matrix) {
        int len = matrix.length;
        int temp;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0, k = len - 1; j < len / 2; j++, k--) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }
}
