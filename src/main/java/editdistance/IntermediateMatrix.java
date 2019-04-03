package editdistance;

import java.util.Scanner;

public class IntermediateMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int[][] matrix = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0)
                    matrix[i][j] = j;
                else if (j == 0)
                    matrix[i][j] = i;
                else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                }
                else {
                    matrix[i][j] = 1 + Math.min(Math.min(matrix[i][j - 1], matrix[i - 1][j]), matrix[i - 1][j - 1]);
                }
            }
        }

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
