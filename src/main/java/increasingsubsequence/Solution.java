package increasingsubsequence;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (numbers.length == 1) {
            System.out.println(numbers[0]);
        } else {
            int[] d = new int[numbers.length];

            int totalMaxIndex = 0;
            int totalMax = Integer.MIN_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                int result = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (numbers[i] > numbers[j]) {
                        result = Math.max(result, d[j] + 1);
                        if (totalMax < result) {
                            totalMax = result;
                            totalMaxIndex = i;
                        }
                    }
                }
                d[i] = result;
            }

            Arrays.stream(d).forEach(x -> System.out.print(x + " "));
            System.out.println();

            List<Integer> solutions = new LinkedList<>();
            solutions.add(numbers[totalMaxIndex]);
            int lastSeen = totalMax;

            for (int i = totalMaxIndex; i >= 0; i--) {
                if (d[i] == lastSeen - 1) {
                    solutions.add(0, numbers[i]);
                    lastSeen = d[i];
                }
            }

            for (int pos: solutions) {
                System.out.print(pos + " ");
            }
        }
    }
}