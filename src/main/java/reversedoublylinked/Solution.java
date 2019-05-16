package reversedoublylinked;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node) {
        while (node != null) {
            System.out.println(node.data);

            node = node.next;
        }
    }

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head;
        DoublyLinkedListNode newHead = current;
        DoublyLinkedListNode prev = null;
        while (current != null) {
            newHead = current;
            current = current.next;
            newHead.next = prev;
            newHead.prev = current;
            prev = newHead;
        }
        return newHead;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            printDoublyLinkedList(llist.head);

            DoublyLinkedListNode llist1 = reverse(llist.head);

            printDoublyLinkedList(llist1);
        }
        scanner.close();
    }
}

