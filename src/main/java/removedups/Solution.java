package removedups;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String prevNumber = scanner.nextLine();
        if (n == 1) {
            System.out.println(prevNumber);
        } else {
            String currentNumber = "";
            for (int i = 1; i < n; i++) {
                currentNumber = scanner.nextLine();
                if (!currentNumber.equals(prevNumber)) {
                    System.out.println(prevNumber);
                    prevNumber = currentNumber;
                }
            }

            System.out.println(currentNumber);
        }
    }
}
