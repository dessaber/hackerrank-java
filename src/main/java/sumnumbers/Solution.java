package sumnumbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new BufferedReader(new InputStreamReader(System.in)).lines().mapToInt(Integer::parseInt).sum());
    }
}