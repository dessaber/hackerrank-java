package sumneighbours;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<BigInteger[]> queue = new LinkedList<>();
        String line = scanner.nextLine();

        while (!"end".equals(line)) {
            queue.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt)
                                                           .boxed()
                                                           .map(BigInteger::valueOf)
                                                           .toArray(BigInteger[]::new));
            line = scanner.nextLine();
        }

        int n = queue.size();
        int m = queue.peek().length;
        BigInteger[][] matrix = new BigInteger[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = queue.poll();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(sumNeighbours(matrix, i, j) + " ");
            }
            System.out.println();
        }
    }

    private static BigInteger sumNeighbours(BigInteger[][] matrix, int i, int j) {
        BigInteger newValue = BigInteger.ZERO;
        BigInteger addend;

        int rows = matrix.length;
        int columns = matrix[i].length;

        addend = i == 0 ? matrix[rows - 1][j] : matrix[i - 1][j];
        newValue = newValue.add(addend);

        addend = i == rows - 1 ? matrix[0][j] : matrix[i + 1][j];
        newValue = newValue.add(addend);

        addend = j == 0 ? matrix[i][columns - 1] : matrix[i][j - 1];
        newValue = newValue.add(addend);

        addend = j == columns - 1 ? matrix[i][0] : matrix[i][j + 1];
        return newValue.add(addend);
    }
}
