package compressstring;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        System.out.println(compress(input, 1, input[0], 1, new StringBuilder()));
    }

    public static String compress(char[] input, int currentPos, char currentSymbol, int currentFreq, StringBuilder builder) {
        if (currentPos == input.length - 1) {
            builder.append(currentSymbol);
            if (input[currentPos] != currentSymbol) {
                builder.append(currentFreq);
                builder.append(input[currentPos]);
                builder.append(1);
            } else {
                builder.append(currentFreq + 1);
            }
            return builder.toString();
        }
        if (input[currentPos] != currentSymbol) {
            builder.append(currentSymbol);
            builder.append(currentFreq);
            return compress(input, currentPos + 1, input[currentPos], 1, builder);
        } else {
            return compress(input, currentPos + 1, currentSymbol, currentFreq + 1, builder);
        }
    }

}
