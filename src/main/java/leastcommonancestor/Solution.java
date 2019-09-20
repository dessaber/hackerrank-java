package leastcommonancestor;

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "leastcommonancestor.Node{" +
                "data=" + data +
                '}';
    }
}

class Solution {

    /*
    class leastcommonancestor.Node
        int data;
        leastcommonancestor.Node left;
        leastcommonancestor.Node right;
    */
    public static Node lca(Node root, int v1, int v2) {
        List<Node> left = findPath(root, new ArrayList<>(), v1);
        List<Node> right = findPath(root, new ArrayList<>(), v2);

        int minSize = Math.min(left.size(), right.size());
        Node prev = null;
        for (int i = 0; i < minSize && left.get(i).data == right.get(i).data; i++) {
            prev = left.get(i);
        }

        return prev;
    }

    private static List<Node> findPath(Node root, List<Node> current, int target) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.data == target) {
            current.add(root);
            return current;
        }

        current.add(root);

        List<Node> copyForLeft = new ArrayList<>(current);
        List<Node> copyForRight = new ArrayList<>(current);

        List<Node> left = findPath(root.left, copyForLeft, target);
        List<Node> right = findPath(root.right, copyForRight, target);

        //System.out.println(left + " " + target + " kzeze");
        //System.out.println(right + " " + target + " kek");

        if (left.isEmpty() && right.isEmpty()) {
            return new ArrayList<>();
        }

        return left.isEmpty() ? right : left;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans);
    }
}