package minabsdiff;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int minDiff = Math.abs(numbers[numbers.length - 1] - numbers[0]);
        for (int i = 1; i < n; i++) {
            int currDiff = Math.abs(numbers[i] - numbers[0]);
            if (currDiff < minDiff) {
                minDiff = currDiff;
            }
        }
        System.out.println(minDiff);
    }
}
