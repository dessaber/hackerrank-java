package heap;

import java.util.Arrays;
import java.util.Scanner;

public class Heap {

    private int elementsAmount = 0;
    private int[] storage;

    public Heap(int size) {
        storage = new int[size];
    }

    public Heap() {
        this(10000);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Heap myHeap = new Heap();
        /*for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]) {
                case "Insert": myHeap.insert(Integer.parseInt(command[1]));
                               break;
                case "ExtractMax": System.out.println(myHeap.extractMax());
                                   break;
                default: throw new RuntimeException("Incorrect priority queue command");
            }
        }*/

        myHeap.insert(3);
        myHeap.insert(0);
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap);
        myHeap.insert(32323);
        myHeap.insert(334);
        myHeap.insert(11111);
        System.out.println(myHeap);
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap);
        myHeap.insert(323123123);
        myHeap.insert(100000000);
        myHeap.insert(323123123);
        myHeap.insert(100000000);
        myHeap.insert(323123123);
        myHeap.insert(100000000);
        myHeap.insert(323123123);
        myHeap.insert(100000000);
        myHeap.insert(323123123);
        myHeap.insert(100000000);
        myHeap.insert(323123123);
        myHeap.insert(100000000);
        myHeap.insert(323123123);
        myHeap.insert(100000000);
        myHeap.insert(323123123);
        myHeap.insert(100000000);
        System.out.println(myHeap);
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap.extractMax());
        System.out.println(myHeap);
    }

    @Override
    public String toString() {
        return "Heap{" +
                "storage=" + Arrays.toString(storage) +
                '}';
    }

    private void siftUp(int i) {
        if (i > 1) {
            int parentIndex = i / 2;
            if (storage[parentIndex] < storage[i]) {
                swap(i, parentIndex);
                siftUp(parentIndex);
            }
        }
    }

    private void siftDown(int i) {
        int leftIndex = 2 * i;
        int rightIndex = leftIndex + 1;
        if (leftIndex <= elementsAmount && rightIndex <= elementsAmount) {
            if (storage[i] < storage[leftIndex] && storage[i] < storage[rightIndex]) {
                if (storage[leftIndex] > storage[rightIndex]) {
                    swap(i, leftIndex);
                    siftDown(leftIndex);
                } else {
                    swap(i, rightIndex);
                    siftDown(rightIndex);
                }
            } else if (storage[i] < storage[leftIndex]) {
                swap(i, leftIndex);
                siftDown(leftIndex);
            } else if (storage[i] < storage[rightIndex]) {
                swap(i, rightIndex);
                siftDown(rightIndex);
            }
        } else if (leftIndex <= elementsAmount) {
            swap(i, leftIndex);
            siftDown(leftIndex);
        }
    }

    public void insert(int data) {
        int index = ++elementsAmount;
        storage[index] = data;
        siftUp(index);
    }

    public int extractMax() {
        int result = storage[1];
        storage[1] = 0;
        swap(1, elementsAmount--);
        siftDown(1);
        return result;
    }

    private void swap(int i, int j) {
        int temp = storage[i];
        storage[i] = storage[j];
        storage[j] = temp;
    }
}

