package adviser;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern sentencePattern = Pattern.compile("((\\w+\\s?)*\\w+[.?!]?)");
        Pattern wordPattern = Pattern.compile("\\w+");
        Matcher sentenceMatcher = sentencePattern.matcher(text);
        int amountOfSentences = 0;
        int wordsPerSentence = 0;
        while (sentenceMatcher.find()) {
            amountOfSentences++;
            String sentence = sentenceMatcher.group(1);
            Matcher wordMatcher = wordPattern.matcher(sentence);
            while (wordMatcher.find()) {
                wordsPerSentence++;
            }
            System.out.println(sentence);
            System.out.println(amountOfSentences + " " + wordsPerSentence);
        }
        double target = 10;
        System.out.println(wordsPerSentence * 1.0 / amountOfSentences > target ? "HARD" : "EASY");
    }
}