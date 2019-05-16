package regex.html;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("</(\\w+)>");
        Set<String> tags = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            System.out.println(input);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                tags.add(matcher.group(1));
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String tag : tags) {
            builder.append(tag);
            builder.append(";");
        }
        builder.setLength(builder.length() - 1);
        System.out.println(builder);
    }
}
