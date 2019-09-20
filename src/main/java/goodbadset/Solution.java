package goodbadset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < size; i++) {
            String word = scanner.next();
            if (!trie.insert(word)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
        }

        System.out.println("GOOD SET");
    }
}

class Trie {
    static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEnd;

        private TrieNode() {
            children = new HashMap<>();
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.isEnd) {
                return false;
            }
            char newSymbol = word.charAt(i);
            if (!current.children.containsKey(newSymbol)) {
                current.children.put(newSymbol, new TrieNode());
            }
            current = current.children.get(newSymbol);
        }

        if (current.isEnd) {
            return false;
        }
        current.isEnd = true;
        return current.children.isEmpty();
    }
}
