package findmatrixpattern;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        Pattern pattern = Pattern.compile("(?=(" + P[0] + "))");
        for (int i = 0; i < G.length; i++) {
            Matcher matcher = pattern.matcher(G[i]);
            while (matcher.find()) {
                int firstRowPosition = matcher.start(1);

                int k = 1;
                for (int j = 1; j + i < G.length && k < P.length; j++) {
                    if (j != k) {
                        break;
                    }
                    Pattern anotherPattern = Pattern.compile("(?=(" + P[k] + "))");
                    Matcher anotherMatcher = anotherPattern.matcher(G[j + i]);
                    while (anotherMatcher.find()) {
                        int anotherRowPosition = anotherMatcher.start(1);

                        if (anotherRowPosition == firstRowPosition) {
                            k++;
                        }
                    }
                }

                if (k == P.length) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            System.out.println(gridSearch(G, P));

            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
