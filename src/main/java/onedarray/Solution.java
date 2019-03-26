package onedarray;

import java.util.Scanner;

public class Solution {
    private static int leap;
    private static int[] game;

    private static boolean canWin(int leap, int[] game) {
        Solution.leap = leap;
        Solution.game = game;
        return canMove(0);
    }

    private static boolean canMove(int start) {
        if (start < 0 || game[start] == 1)
            return false;
        else if (start == game.length - 1 || start + leap >= game.length)
            return true;

        game[start] = 1;
        return canMove(start + 1) || canMove(start - 1) || canMove(start + leap);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}