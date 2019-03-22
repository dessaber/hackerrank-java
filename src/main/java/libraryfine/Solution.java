package libraryfine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Solution {

    // Complete the libraryFine function below.
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        LocalDate actualDate = LocalDate.of(y1, m1, d1);
        LocalDate expectedDate = LocalDate.of(y2, m2, d2);
        if (expectedDate.isAfter(actualDate)) {
            return 0;
        } else if (expectedDate.getYear() == actualDate.getYear()) {
            if (expectedDate.getMonth().equals(actualDate.getMonth()))
                return 15 * (actualDate.getDayOfMonth() - expectedDate.getDayOfMonth());
            else
                return 500 * (actualDate.getMonth().getValue() - expectedDate.getMonth().getValue());
        } else
            return 10000;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] d1M1Y1 = scanner.nextLine().split(" ");

        int d1 = Integer.parseInt(d1M1Y1[0]);

        int m1 = Integer.parseInt(d1M1Y1[1]);

        int y1 = Integer.parseInt(d1M1Y1[2]);

        String[] d2M2Y2 = scanner.nextLine().split(" ");

        int d2 = Integer.parseInt(d2M2Y2[0]);

        int m2 = Integer.parseInt(d2M2Y2[1]);

        int y2 = Integer.parseInt(d2M2Y2[2]);

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
