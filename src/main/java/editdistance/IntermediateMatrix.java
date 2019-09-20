package editdistance;

import java.util.Scanner;

public class IntermediateMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int[][] matrix = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0)
                    matrix[i][j] = j;
                else if (j == 0)
                    matrix[i][j] = i;
                else {
                    int addend = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;
                    matrix[i][j] =  Math.min(Math.min(matrix[i][j - 1] + 1, matrix[i - 1][j] + 1), matrix[i - 1][j - 1] + addend);
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
