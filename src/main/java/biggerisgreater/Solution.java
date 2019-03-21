package biggerisgreater;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        char[] symbols = w.toCharArray();
        int invertedCounter = w.length() - 2;
        while (invertedCounter >= 0 && symbols[invertedCounter] >= symbols[invertedCounter + 1]) {
            invertedCounter--;
        }
        if (invertedCounter == -1)
            return "no answer";
        else {
            int pivotSearchCounter = w.length() - 1;
            // find pivot element
            while (pivotSearchCounter >= 1 && symbols[pivotSearchCounter] <= symbols[invertedCounter]) {
                pivotSearchCounter--;
            }
            // swap with pivot element
            char tmp = symbols[pivotSearchCounter];
            symbols[pivotSearchCounter] = symbols[invertedCounter];
            symbols[invertedCounter] = tmp;
            // start to form output string
            StringBuilder result = new StringBuilder();
            result.append(symbols, 0, invertedCounter + 1);
            char[] invertedSuffix = Arrays.copyOfRange(symbols, invertedCounter + 1, symbols.length);
            // add reversed suffix from original string
            for (int i = invertedSuffix.length - 1; i >= 0; i--) {
                result.append(invertedSuffix[i]);
            }
            return result.toString();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
