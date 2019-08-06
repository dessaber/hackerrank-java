package greedy;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;


class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        MyHeap myHeap = new MyHeap(n);
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(myHeap::insert);
        int power = Integer.parseInt(scanner.nextLine());

        int totalTries = 0;
        while (myHeap.size() != 0) {
            System.out.println(myHeap);
            int currentTry = 0;
            List<Integer> pickedFruits = new LinkedList<>();
            while (myHeap.size() != 0 && currentTry < power && power - currentTry >= myHeap.peek()) {
                int pickedFruit = myHeap.remove();
                currentTry += pickedFruit;
                pickedFruits.add(pickedFruit);
            }

            while (pickedFruits.size() != 0) {
                int fruit = pickedFruits.remove(0);
                if (fruit > 1) {
                    myHeap.insert(fruit / 2);
                }
            }

            totalTries++;
        }

        System.out.println(totalTries);
    }
}

class MyHeap {
    private int currentPos;
    private int[] storage;

    MyHeap(int size) {
        storage = new int[size];
    }

    private void swap(int i, int j) {
        int temp = storage[i];
        storage[i] = storage[j];
        storage[j] = temp;
    }

    int size() {
        return currentPos;
    }

    private boolean isLeaf(int i) {
        return 2 * i + 1 >= currentPos;
    }

    private boolean hasRightChild(int i) {
        return 2 * i + 2 < currentPos;
    }

    private void sink(int i) {
        if (!isLeaf(i)) {
            if (hasRightChild(i)) {
                if (storage[2 * i + 1] > storage[2 * i + 2]) {
                    if (storage[i] < storage[2 * i + 1]) {
                        swap(i, 2 * i + 1);
                        sink(2 * i + 1);
                    }
                } else if (storage[i] < storage[2 * i + 2]) {
                    swap(i, 2 * i + 2);
                    sink(2 * i + 2);
                }
            } else if (storage[i] < storage[2 * i + 1]) {
                swap(i, 2 * i + 1);
                sink(2 * i + 1);
            }
        }
    }

    int remove() {
        int result = storage[0];
        storage[0] = storage[currentPos - 1];
        storage[--currentPos] = 0;
        sink(0);

        return result;
    }

    private void raise(int i) {
        while (storage[i / 2] < storage[i]) {
            swap(i, i / 2);
            i /= 2;
        }
    }

    void insert(int data) {
        storage[currentPos] = data;
        raise(currentPos++);
    }

    int peek() {
        return storage[0];
    }

    @Override
    public String toString() {
        return "MyHeap{" +
                "storage=" + Arrays.toString(storage) +
                '}';
    }
}