package pickingnumbers;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    private static Map<Integer, ArrayList<Integer>> lists = new HashMap<>();
    private static int maxListLength = 0;

    public static int pickingNumbers(List<Integer> a) {

        for (int number: a) {
            checkForListByNumber(number - 1);
            checkForListByNumber(number);
        }

        return maxListLength;
    }

    private static void checkForListByNumber(int number) {
        ArrayList<Integer> existingList = lists.containsKey(number) ? lists.get(number) : new ArrayList<>();
        existingList.add(number);
        lists.put(number, existingList);
        if (existingList.size() > maxListLength)
            maxListLength = existingList.size();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
