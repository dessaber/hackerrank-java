package rabinkarp;

import java.util.Scanner;

public class Solution {
    private static int base = 3;
    private static int divisor = 11;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        String pattern = scanner.nextLine();

        String currString = target.substring(target.length() - pattern.length());
        long substrHash = countHash(currString);
        long patternHash = countHash(pattern);
        System.out.println(compareWithHash(target, pattern, substrHash, patternHash, target.length() - pattern.length()));
        System.out.println(-1694 % 11 + " " + -1682 % 11 + " " + mod(-1694, 11));

        int lastCharIndex = pattern.length() - 1;
        for (int i = target.length() - pattern.length() - 1; i >= 0; i--) {
            System.out.println(String.format("%c %c (%d - %d * %d) * %d + %d", (int)target.charAt(i), (int)target.charAt(i + pattern.length()),  substrHash, (int)target.charAt(i + pattern.length()), (int) Math.pow(base, lastCharIndex), base, (int)target.charAt(i)));
            System.out.println(mod((substrHash - target.charAt(i + pattern.length()) *
                    (int) Math.pow(base, lastCharIndex)
            ) * base + target.charAt(i), 11));
            substrHash = mod (
                            (substrHash - target.charAt(i + pattern.length()) *
                                          (int) Math.pow(base, lastCharIndex)
                            ) * base + target.charAt(i), divisor);
            System.out.println((substrHash - target.charAt(i + pattern.length()) *
                    (int) Math.pow(base, lastCharIndex)
            ) * base + target.charAt(i));
            System.out.println(compareWithHash(target, pattern, substrHash, patternHash, i));
        }
    }

    private static long countHash(String input) {
        long result = 0;
        int power = 0;
        for (char c: input.toCharArray()) {
            result += c * Math.pow(base, power++);
        }

        return mod(result, divisor);
    }

    private static int minComparisons(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            count++;
            if (a.charAt(i) != b.charAt(i)) {
                break;
            }
        }

        return count;
    }

    private static String compareWithHash(String target, String pattern, long inputHash, long patternHash, int start) {
        int comparisons;
        String currString = "";

        if (patternHash == inputHash) {
            currString = target.substring(start, start + pattern.length());
            comparisons = minComparisons(pattern, currString);
        } else {
            comparisons = 0;
        }
        int intermResult = patternHash != inputHash || comparisons != pattern.length() ? 0 : currString.charAt(0) == pattern.charAt(0) ? 1 : 0;

        return String.format("%d %d %d", inputHash, comparisons, intermResult);
    }

    private static long mod(long n, long m) {
        if (n > 0)
            return n % m;
        else
            return m + n % m;
    }
}
