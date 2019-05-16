package anagrams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> freqs = new HashMap<>();
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        for (Character symbol : first.toCharArray()) {
            int oldFreq = freqs.getOrDefault(symbol, 0);
            freqs.put(symbol, ++oldFreq);
        }
        for (Character symbol : second.toCharArray()) {
            if (!freqs.containsKey(symbol)) {
                System.out.println(0);
                return;
            } else {
                int oldFreq = freqs.get(symbol);
                oldFreq--;
                if (oldFreq == 0) {
                    freqs.remove(symbol);
                } else {
                    freqs.put(symbol, oldFreq);
                }
            }
        }
        if (freqs.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}