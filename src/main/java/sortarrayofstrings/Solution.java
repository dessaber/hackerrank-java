package sortarrayofstrings;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        for (int i = 1; i < words.length; i++) {
            if (!compareStrings(words[i - 1], words[i])) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    private static boolean compareStrings(String a, String b) {
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) > b.charAt(i)) {
                return false;
            }
        }
        return a.length() <= b.length();
    }
}
