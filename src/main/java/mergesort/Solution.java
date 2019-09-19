package mergesort;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        mergeSort(numbers, 0, numbers.length);

        //Arrays.stream(numbers).forEach(x -> System.out.print(x + " "));

        System.out.println(count);
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left + 1 < right) {
//            for (int i = left; i < right; i++) {
//                System.out.print(array[i] + " ");
//            }
//            System.out.println();

            int middle = left + (right - left) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle, right);

            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        count++;
        int[] temp = new int[right - left];

        int i = left;
        int j = middle;
        int k = 0;

        while (i < middle && j < right) {
            if (array[i] < array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        while (i < middle) {
            temp[k] = array[i];
            i++;
            k++;
        }

        while (j < right) {
            temp[k] = array[j];
            j++;
            k++;
        }

        System.arraycopy(temp, 0, array, left, temp.length);
    }
}
