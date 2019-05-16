package conseqones;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int totalMax = 0;
        int currentMax = 0;
        for (int i = 0; i < n; i++) {
            int currentSymbol = scanner.nextInt();
            if (currentSymbol == 1) {
                currentMax++;
                if (currentMax > totalMax) {
                    totalMax = currentMax;
                }
            } else {
                currentMax = 0;
            }
        }

        System.out.println(totalMax);
    }
}
