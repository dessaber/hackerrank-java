import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
            String[] contents = readSentences("src/in.txt");
            System.out.println("The text is: ");
            for (String line : contents) {
                System.out.print(line);
            }
            System.out.println();
            List<String> sentences = new LinkedList<>();
            Pattern pattern = Pattern.compile("(\\w[\\w+(\\s,)?]+[!?.]?)+");
            for (String line : contents) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    sentences.add(matcher.group(0));
                }
            }
            double totalWords = 0d;
            double totalChars = 0d;
            for (String sentence : sentences) {
                String[] words = sentence.trim().split(" ");
                System.out.println(sentence + " " + words.length);
                totalWords += words.length;
                for (String word : words) {
                    System.out.println(word + " " + word.length());
                    totalChars += word.length();
                }
            }
            System.out.println("Words: " + totalWords);
            System.out.println("Sentences: " + sentences.size());
            System.out.println("Characters: " + totalChars);
            System.out.println("The score is: " + (4.71 * totalChars / totalWords + 0.5 * totalWords / sentences.size() - 21.43));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] readSentences(String fileName) throws IOException {
        Scanner scanner = new Scanner(new File(fileName));
        List<String> lines = new LinkedList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        return lines.stream().toArray(String[]::new);
    }
}

