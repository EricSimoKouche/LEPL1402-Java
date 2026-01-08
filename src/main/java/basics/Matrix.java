package basics;

public class Matrix {

    /**
     * Create a matrix from a String.
     *
     * The string if formatted as follows:
     *  - Each row of the matrix is separated by a newline
     *    character \n
     *  - Each element of the rows are separated by a space
     *
     *  @param s The input String
     *  @return The matrix represented by the String
     */
    public static int[][] buildFrom(String s) {

        String[] sentences = s.split("\n");
        int[][] M = new int[sentences.length][];

        for (int i = 0; i < sentences.length; i++) {
            String[] words = sentences[i].split(" ");
            M[i] = new int[words.length];
            for (int j = 0; j < words.length; j++) {
                M[i][j] = Integer.parseInt(words[j]);
            }
        }
        return M;
    }


    /**
     * Compute the sum of the element in a matrix
     *
     * @param matrix The input matrix
     * @return The sum of the element in matrix
     */
    public static int sum(int[][] matrix) {

        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res += matrix[i][j];
            }
        }
        return res;
    }

    /**
     * Compute the transpose of a matrix
     *
     * @param matrix The input matrix
     * @return A new matrix that is the transpose of matrix
     */
    public static int[][] transpose(int[][] matrix) {

        int[][] transposed = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[0].length; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }
        return transposed;
    }

    /**
     * Compute the product of two matrix
     *
     * @param matrix1 A n x m matrix
     * @param matrix2 A m x k matrix
     * @return The n x k matrix product of matrix1 and matrix2
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {

        int[][] M = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int k = 0; k < matrix2.length; k++) {
                for (int j = 0; j < M[0].length; j++) {
                    M[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return M;
    }
}