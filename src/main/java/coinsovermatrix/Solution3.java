package coinsovermatrix;

import java.util.*;

public class Solution3 {
    private static int totalMin = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        step(matrix, 0, 0, 0);

        System.out.println(totalMin);
    }

    private static void step(int[][] coins, int i, int j, int sum) {
        if (i == coins.length - 1 && j == coins[i].length - 1) {
            int result = sum + coins[i][j];
            if (totalMin > result) {
                totalMin = result;
            }
        } else {
            sum += coins[i][j];
            if (i == coins.length - 1) {
                step(coins, i, j + 1, sum);
            } else if (j == coins[i].length - 1) {
                step(coins, i + 1, j, sum);
            } else {
                step(coins, i + 1, j, sum);
                step(coins, i, j + 1, sum);
            }
        }
    }
}
