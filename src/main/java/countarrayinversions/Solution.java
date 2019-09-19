package countarrayinversions;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    static int inversions = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] numbers = IntStream.generate(scanner::nextInt).limit(size).toArray();

        countInversions(numbers, 0, numbers.length);
        System.out.print(inversions);
    }

    private static void countInversions(int[] array, int left, int right) {
        if (left + 1 < right) {
            int middle = left + (right - left) / 2;
            countInversions(array, left, middle);
            countInversions(array, middle, right);

            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int[] temp = new int[right - left];
        int i = left;
        int j = middle;
        int k = 0;

        //System.out.println(left + " " + middle + " " + right);
        while (i < middle && j < right) {
            if (array[i] > array[j]) {
                inversions += (middle - left) - (i - left);
                temp[k++] = array[j++];
            } else {
                temp[k++] = array[i++];
            }
        }

        while (i < middle) {
            temp[k++] = array[i++];
        }

        while (j < right) {
            temp[k++] = array[j++];
        }

        System.arraycopy(temp, 0, array, left, temp.length);
    }
}
