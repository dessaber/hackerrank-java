package isfulltree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int edges = Integer.parseInt(scanner.nextLine());
        if (edges == 0) {
            System.out.print("yes");
        } else if (edges == 1) {
            System.out.print("no");
        } else {
            Integer[] tree = new Integer[edges + 2];
            while (edges-- > 0) {
                String[] line = scanner.nextLine().split(" ");
                int source = Integer.parseInt(line[0]);
                tree = resizeArray(tree, source);
                int target = Integer.parseInt(line[1]);
                tree = resizeArray(tree, target);
                tree[source + 1] = source;
                tree[target + 1] = target;
            }

            for (int i = 1; i < tree.length; i++) {
                if (tree[i] == null) {
                    System.out.println("no");
                    return;
                }
            }
            System.out.println("yes");
        }
    }

    private static Integer[] resizeArray(Integer[] source, int n) {
        if (n + 2 > source.length)
            return Arrays.copyOf(source, n + 2);
        return source;
    }
}
