package caesar;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int shift = scanner.nextInt();
        StringBuilder input = new StringBuilder(scanner.nextLine());
        for (int i = 0; i < input.length(); i++) {
            int currentIndex = Arrays.binarySearch(alphabet, input.charAt(i));
            int adjustedIndex = (currentIndex + shift) % alphabet.length;
            if (adjustedIndex > alphabet.length - 1) {
                adjustedIndex = adjustedIndex - alphabet.length;
            } else if (adjustedIndex < 0) {
                adjustedIndex = alphabet.length - adjustedIndex;
            }
            input.setCharAt(i, alphabet[adjustedIndex]);
        }
        System.out.println(input);
    }
}