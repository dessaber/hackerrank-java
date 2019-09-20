package findmaxstockprofit;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
                int n = Integer.parseInt(scanner.nextLine().trim());

                List<Integer> prices = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                System.out.println(stockmax(prices));
        });
    }

    public static long stockmax(List<Integer> prices) {
        long result = 0;
        int totalMax = Integer.MIN_VALUE;

        for (int i = prices.size() - 1; i >= 0; i--) {
            int current = prices.get(i);
            if (current > totalMax) {
                totalMax = current;
            }
            result += totalMax - current;
        }

        return result;
    }
}

