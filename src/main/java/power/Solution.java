package power;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = (int)Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        System.out.println(getPower(n, power));
    }

    public static int getPower(int number, int power) {
        if (power == 1)
            return number;
        else if (power % 2 == 1)
            return getPower(number * number, power / 2);
        else
            return number * getPower(number, power - 1);
    }
}