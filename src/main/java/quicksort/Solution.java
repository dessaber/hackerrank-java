package quicksort;


import java.util.Arrays;

public class Solution {

    private static void sort(int[] numbers, int from, int to) {
        if (from >= to) return;

        int j = partitition(numbers, from, to);
        sort(numbers, 0, j);
        sort(numbers, j + 1, to);
    }

    private static int partitition(int[] numbers, int from, int to) {
        int pivot = numbers[from];
        int i = from - 1;
        int j = to + 1;

        while (i < j) {
            i++;
            while (numbers[i] < pivot)
                i++;

            j--;
            while (numbers[j] > pivot)
                j--;

            if (i < j)
                swap(numbers, i, j);
        }

        return j;
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 5, 0, -1};

        sort(numbers, 0, numbers.length -  1);

        for (int n: numbers)
            System.out.println(n);
    }
}
