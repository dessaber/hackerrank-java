package searchengine;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of people:");
        int linesAmount = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter all people:");
        String[] lines = new String[linesAmount];

        for (int i = 0; i < linesAmount; i++) {
            lines[i] = scanner.nextLine();
        }
        System.out.println();

        System.out.println("Enter the number of search queries:");
        int queries = Integer.parseInt(scanner.nextLine());
        System.out.println();

        while (queries-- > 0) {
            System.out.println("Enter data to search people:");
            Pattern pattern = Pattern.compile("(?i)" + scanner.nextLine());
            System.out.println();

            boolean firstMatch = true;
            for (String line: lines) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    if (firstMatch) {
                        System.out.println("Found people:");
                        firstMatch = false;
                    }
                    System.out.println(line);
                }
            }
            System.out.println();
        }
    }
}