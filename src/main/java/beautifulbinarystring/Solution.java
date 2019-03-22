package beautifulbinarystring;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        String pattern = "010";
        StringBuilder changeableString = new StringBuilder(b);
        int currentPos = changeableString.indexOf(pattern);
        int result = 0;
        while (currentPos != -1) {
            System.out.println(changeableString);
            System.out.println(result);
            changeableString.delete(0, currentPos + pattern.length());
            currentPos = changeableString.indexOf(pattern);
            result++;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
