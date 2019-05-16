package triplets;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    /**
     * In arrays a, b, c find all unique triplets p from a, q from b, r from c
     * so that p <= q and q >= r
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = parseStringToIntStream(scanner.nextLine()).toArray();
        int[][] arrays = new int[sizes.length][];
        for (int i = 0; i < sizes.length; i++) {
            arrays[i] = parseStringToIntStream(scanner.nextLine()).sorted().distinct().toArray();
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }

        BigInteger result = BigInteger.ZERO;
        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;

        while (bIndex < arrays[1].length) {
            while (aIndex < arrays[0].length && arrays[0][aIndex] <= arrays[1][bIndex]) {
                aIndex++;
            }

            while (cIndex < arrays[2].length && arrays[2][cIndex] <= arrays[1][bIndex]) {
                cIndex++;
            }
            result = result.add(BigInteger.valueOf(aIndex).multiply(BigInteger.valueOf(cIndex)));
            bIndex++;
        }
        System.out.println(result);
    }

    private static IntStream parseStringToIntStream(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt);
    }
}
