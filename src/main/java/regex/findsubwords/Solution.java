package regex.findsubwords;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < n; i++) {
            input.append(scanner.nextLine());
            input.append(" ");
        }
        int q = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < q; i++) {
            String query = scanner.nextLine();
            Pattern pattern = Pattern.compile("\\B" + query + "\\B");
            Matcher matcher = pattern.matcher(input);
            int count = 0;
            while (matcher.find()) {
                count++;
            }
            System.out.println(count);
        }
    }
}
