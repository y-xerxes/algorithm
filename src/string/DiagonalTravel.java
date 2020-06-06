package string;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTravel {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{2, 3}};
        int[] result = findDiagonalOrder(matrix);
        for (int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        int[] result = new int[]{};
        if (matrix.length == 0) {
            return result;
        }
        result = new int[matrix.length * matrix[0].length];

        result[0] = matrix[0][0];
        int resultLength = 1;

        int length = ((matrix.length > matrix[0].length ? matrix.length : matrix[0].length) - 1) * 2;
        boolean reverse = true;
        for (int i=1; i<=length; i++) {
            for (int y=0; y<=i; y++) {
                if (reverse) {
                    if (y < matrix.length && (i - y) < matrix[0].length) {
                        result[resultLength++] = matrix[y][i - y];
                    }
                }else {
                    if ((i-y) < matrix.length && y < matrix[0].length) {
                        result[resultLength++] = matrix[i - y][y];
                    }
                }
            }
            reverse = !reverse;
        }
        return result;
    }
}
