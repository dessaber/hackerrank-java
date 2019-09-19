package I0knapsack;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();

        int[] weights = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int[][] matrix = new int[n][capacity + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) {
                    matrix[i][j] = 0;
                } else if (i == 0) {
                    matrix[i][j] = weights[i] > j ? 0 : weights[i];
                } else if (weights[i] == j) {
                    matrix[i][j] = j;
                } else if (weights[i] > j) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    int diff = j - weights[i];
                    matrix[i][j] = Math.max(matrix[i - 1][j], weights[i] + matrix[i - 1][diff]);
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(matrix[matrix.length - 1][capacity]);
    }
}