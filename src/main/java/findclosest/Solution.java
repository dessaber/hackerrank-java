package findclosest;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int[] target = new int[]{10, 20, 30};
        int[] queries = new int[]{9, 15, 35};
        for (Integer query : queries) {
            int index = Arrays.binarySearch(target, query);
            int result = 0;
            if (index >= 0) {
                result = index;
            } else {
                index = Math.abs(index);
                if (index == 1) {
                    result = 0;
                } else if (index > target.length) {
                    result = target.length - 1;
                } else {
                    int left = index - 2;
                    int right = index - 1;
                    if (query - target[left] > target[right] - query) {
                        result = right;
                    } else {
                        result = left;
                    }
                }
            }
            System.out.print(result + " ");
        }
    }
}