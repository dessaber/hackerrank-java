package omitspaces;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] first = scanner.nextLine().toCharArray();
        char[] second = scanner.nextLine().toCharArray();
        int firstCount = 0;
        int secondCount = 0;
        while (firstCount < first.length && secondCount < second.length) {
            while (first[firstCount] == ' ') {
                firstCount++;
            }

            while (second[secondCount] == ' ') {
                secondCount++;
            }

            if (first[firstCount] == second[secondCount]) {
                firstCount++;
                secondCount++;
            } else {
                System.out.println(false);
                return;
            }
        }

        while (firstCount < first.length) {
            if (first[firstCount] == ' ' || first[firstCount] == second[secondCount - 1]) {
                firstCount++;
            } else {
                System.out.println(false);
                return;
            }
        }

        while (secondCount < second.length) {
            if (second[secondCount] == ' ' || first[firstCount - 1] == second[secondCount]) {
                secondCount++;
            } else {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }
}