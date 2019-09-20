package contacts;

import java.io.*;
import java.util.*;

public class Solution {

    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */

        List<Integer> result = new ArrayList<>();

        Trie trie = new Trie();
        for (int i = 0; i < queries.length; i++) {
            switch (queries[i][0]) {
                case "add": trie.insert(queries[i][1]);
                            break;
                case "find": result.add(trie.search(queries[i][1]));
            }
        }

        int[] arrResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arrResult[i] = result.get(i);
        }
        return arrResult;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.println(result[resultItr]);
        }
    }
}

class Trie {

    static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEnd;
        private int count;

        TrieNode() {
             children = new HashMap<>();
             isEnd = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char newSymbol = word.charAt(i);
            if (!current.children.containsKey(newSymbol)) {
                current.children.put(newSymbol, new TrieNode());
            }
            current = current.children.get(newSymbol);
            current.count++;
        }

        current.isEnd = true;
    }

    public int search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char newSymbol = word.charAt(i);
            if (!current.children.containsKey(newSymbol)) {
                return 0;
            }
            current = current.children.get(newSymbol);
        }

        return current.count;
    }
}