package heap;

import java.util.Arrays;

public class Heap {

    private int currentPos;
    private int[] storage;

    public Heap(int size) {
        storage = new int[size];
    }

    private void swap(int i, int j) {
        int temp = storage[i];
        storage[i] = storage[j];
        storage[j] = temp;
    }

    private void raise(int i) {
        while (storage[i / 2] < storage[i]) {
            swap(i, i / 2);
            i /= 2;
        }
    }

    private void sink(int i) {
        if (2 * i + 2 < currentPos) {
            if (storage[2 * i + 1] > storage[2 * i + 2]) {
                if (storage[i] < storage[2 * i + 1]) {
                    swap(i, 2 * i + 1);
                    sink(2 * i + 1);
                } else {
                    swap(i, 2 * i + 2);
                    sink(2 * i + 2);
                }
            } else {
                if (storage[i] < storage[2 * i + 2]) {
                    swap(i, 2 * i + 2);
                    sink(2 * i + 2);
                } else {
                    swap(i, 2 * i + 1);
                    sink(2 * i + 1);
                }
            }
        } else if (2 * i + 1 < currentPos) {
            if (storage[2 * i + 1] > storage[i]) {
                swap(i, 2 * i + 1);
                sink(2 * i + 1);
            }
        }
    }

    private void insert(int data) {
        if (currentPos == storage.length) {
            storage = Arrays.copyOf(storage, storage.length * 2);
        }
        storage[currentPos] = data;
        raise(currentPos++);
    }

    private int remove() {
        int result = storage[0];
        storage[0] = storage[--currentPos];
        sink(0);
        return result;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(16);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        System.out.println(heap);

        heap.insert(1);
        heap.insert(40);
        System.out.println(heap);

        heap.remove();
        heap.remove();
        System.out.println(heap);
    }

    @Override
    public String toString() {
        return "Heap{" +
                "storage=" + Arrays.toString(storage) +
                '}';
    }
}