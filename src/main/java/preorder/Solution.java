package preorder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    private static int nodeCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = fillTree(scanner.nextInt());
        //System.out.println(root.data + " " + root.left.data + " " + root.right.data);
        preOrder(root);
    }

    private static Node fillTree(int n) {
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(nodeCount++);
        if (n > 0) {
            int totalElememtCount = (int) (Math.pow(3, n + 1) / 2 - 0.5);
            queue.add(root);
            while(!queue.isEmpty() && nodeCount < totalElememtCount) {
                Node node = queue.poll();
                node.left = new Node(nodeCount++);
                node.center = new Node(nodeCount++);
                node.right = new Node(nodeCount++);

                queue.add(node.left);
                queue.add(node.center);
                queue.add(node.right);
            }
        }

        return root;
    }

    private static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.center);
            preOrder(root.right);
        }
    }
}

class Node {
    int data;
    Node left;
    Node center;
    Node right;

    Node(int data, Node left, Node center, Node right) {
        this.data = data;
        this.left = left;
        this.center = center;
        this.right = right;
    }

    Node(int data) {
        this(data, null, null, null);
    }

    @Override
    public String toString() {
        return "preorder.Node{" +
                "data=" + data +
                ", left=" + left +
                ", center=" + center +
                ", right=" + right +
                '}';
    }
}