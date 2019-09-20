package binarysearchtree;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        Node root = new Node();
        scanner.nextLine();
        while (queries-- > 0) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]) {
                case "+": if (!root.isInit) {
                    root = new Node(Integer.parseInt(input[1]));
                    root.isInit = true;
                } else {
                    root.addNode(new Node(Integer.parseInt(input[1])));
                }
                break;
                default: if (root.isInit) {
                    System.out.println(root.findNode(Integer.parseInt(input[1]), 0));
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}


class Node {
    int data;
    Node left;
    Node right;
    boolean isInit;

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    Node(int data) {
        this.data = data;
    }

    Node() {

    }

    public void addNode(Node node) {
        if (node != null) {
            if (this.data > node.data) {
                if (this.left != null) {
                    this.left.addNode(node);
                } else {
                    this.left = node;
                }
            } else {
                if (this.right != null) {
                    this.right.addNode(node);
                } else {
                    this.right = node;
                }
            }
        }
    }

    public String findNode(int data, int depth) {
        String result = "no";
        if (this.data == data) {
            result = "" + depth;
        } else if (this.data > data) {
            if (this.left != null) {
                return this.left.findNode(data, depth + 1);
            }
        } else if (this.right != null) {
                return this.right.findNode(data, depth + 1);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}